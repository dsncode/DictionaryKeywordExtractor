package com.dsncode.nlp.analyser.bean

class Token(private val value : String, private val classification : String) {

  def getValue = value  
  def getClassification = classification

  override def toString = "{ 'token': '"+value+"', 'classification': '"+classification+"'}"
  
}