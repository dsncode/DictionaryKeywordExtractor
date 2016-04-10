package com.dsncode.scala

import java.io.File
import scala.io.Source
import java.util.HashSet
import scala.util.matching.Regex

//import scala.collection.JavaConverters._

class Dictionary(path : String) {
 
  private val file = new File(path)
  private val dic = load(file)

  def load(file: File)=
  {
    val start = System.currentTimeMillis()
    val dic = Source.fromFile(file).getLines().toSet
    val end = System.currentTimeMillis();
    println("dic loaded! "+(end-start)+"ms")
    dic
  }
  
  def sayHi()={
    "hi"
  }
  
  def countDictionaryWords()={
    dic.size;
  }
  
  def toJavaSet(scala_set : scala.collection.parallel.immutable.ParSet[String]) : java.util.Set[String] ={
    
    val set : java.util.Set[String] = new java.util.HashSet[String]
    
    scala_set.foreach { x => set.add(x) }
//    println("original: "+scala_set.size+" - new:"+set.size())
    return set;
    
  }
  
  
  def findNouns(text : String) ={
    
    var ans = dic.toStream.par.filter { noun => 
      val pattern = noun.r
      val op = pattern.findFirstIn(text);
      val ans = op.nonEmpty
      ans
    }.seq.sortWith(_.length() < _.length())
    
    
    scala.collection.convert.WrapAsJava.setAsJavaSet(ans.toSet)
//    ans.asJava
  }
  
}