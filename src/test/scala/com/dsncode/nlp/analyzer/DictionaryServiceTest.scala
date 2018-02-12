package com.dsncode.nlp.analyzer

import org.scalatest._
import com.dsncode.nlp.analyser.service.Dictionary

import java.util.concurrent.TimeUnit

import scala.concurrent.Await
import scala.concurrent.duration.Duration


class TokenServiceTest extends WordSpec with Matchers{

  "a Dictionary must" must {
    
    "Given a default dictionary, find all existent tokens" in {
      
      val dic = Dictionary.getInstance();
      val future_nouns = dic.findNouns("are there any doctors in the hospital this evening?")

      val nouns = Await.result(future_nouns,Duration.create(1,TimeUnit.SECONDS))

      val expectedTokens = List("doctor","hospital","evening")
      expectedTokens should contain theSameElementsAs nouns.map(_.getValue)
      
    }
    
  }
    
  

}
  
