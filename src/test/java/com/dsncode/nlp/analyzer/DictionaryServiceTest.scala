package com.dsncode.nlp.analyzer


import org.scalatest._
import com.dsncode.nlp.analyser.service.Dictionary
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import java.io.File


class TokenServiceTest extends WordSpec with Matchers{

  "a Dictionary must" must {
    
    "Given a list of words, find all existent tokens" in {
      
      val dic = Dictionary.getInstance(new File("src/main/resources/nounlist.txt"), "english-nouns");
      val nouns = dic.findNouns("are there any doctors in the hospital this evening?")
      val expectedTokens = List("doctor","hospital","evening")
      expectedTokens should contain theSameElementsAs nouns.map(_.getValue)
      
    }
    
  }
    
  

}
  
