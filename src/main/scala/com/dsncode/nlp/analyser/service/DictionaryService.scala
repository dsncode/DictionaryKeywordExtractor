package com.dsncode.nlp.analyser.service

import java.io.File

import scala.io.Source
import java.util.{HashSet, ResourceBundle}

import scala.util.matching.Regex
import com.dsncode.nlp.analyser.bean.Token
import com.dsncode.nlp.exception.NotFoundException
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}

/**
 * @author daniel silva navarro
 * web www.dsncode.com
 */
class Dictionary private (path : File, classification : String) {
 
  private val file = path
  private val this.classification=classification
  private val dic = load(file)
  
  private def this (path : String, classification : String)
  {
    this(new File(path),classification)
  }

  private def this(path : String)
  {
    this(path,"N/A")
  }
  
  private def load(file: File) : Set[String]=
  {

      if (!isValidSourceFile(file))
        throw new NotFoundException("file path does not exists " + file.getAbsoluteFile);

      val start = System.currentTimeMillis()
      val dic = Source.fromFile(file).getLines().toSet
      val end = System.currentTimeMillis();
      println("dic '" + this.classification + "' words:[" + dic.size + "] loaded! in " + (end - start) + "ms")
      dic

  }
   
  private def isValidSourceFile(file : File) : Boolean = if(file==null || !file.exists() || file.isDirectory()) return false; else return true;
  
  def countDictionaryWords() = if(dic!=null) dic.size else 0
  
  def findNouns(text : String) : Future[List[Token]] = {

    val p = Promise[List[Token]]

    Future {

      val ans = dic.toStream.par.filter { noun =>
        val pattern = noun.r
        val op = pattern.findFirstIn(text);
        val ans = op.nonEmpty
        ans
      }
        .map { value => new Token(value, this.classification) }
        .toList

      p.success(ans)
    }

    p.future
  }
}

object DictionaryService
{

  val resource = ResourceBundle.getBundle("keywords");

  def getInstance() : Dictionary = getInstance(new File(resource.getString("default.dictionary.list")),"english-nouns")

  def getInstance(path : File , classification : String) =
    {
      val dic= new Dictionary(path, classification)
      dic;
    }

}