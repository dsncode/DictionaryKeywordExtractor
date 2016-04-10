package com.dsncode.scala

import java.io.File

import com.dsncode.nlp.analyser.Dictionary

object ScalaDemo extends App{
  
    val dic = Dictionary.getInstance(new File("/home/daniel/dics/nounlist.txt"), "english-nouns");
    println(dic.countDictionaryWords())
    
    val nouns = dic.findNouns("hola amigo underwear")
    println("nouns: "+nouns)
  
}