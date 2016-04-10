package com.dsncode.scala

import com.dsncode.java.JavaDemo

object ScalaDemo {
  
  
  def isPair(value : Int): Boolean ={
    return value%2==0;
  }
  
  def main(args : Array[String]) : Unit = {
  
    val dic = new Dictionary("/home/daniel/dics/nounlist.txt");
    println(dic.countDictionaryWords())
    
    val nouns = dic.findNouns("hola amigo underwear")
    println("nouns: "+nouns)
  }
  
}