# DictionaryKeywordExtractor

Given a txt dictionary, this api can help you to extract that dictionary keywords from an input text.

EXAMPLE: (given a english-nouns.txt input file):
Input: are there any doctors in the hospital this evening?
Output as Set<Token>: 

[{ 'token': 'doctor', 'classification': 'english-nouns'}, 
{ 'token': 'hospital', 'classification': 'english-nouns'}, 
{ 'token': 'evening', 'classification': 'english-nouns'}]


USAGE 
FOR JAVA:

	String text = "are there any doctors in the hospital this evening?";
	Dictionary dic = Dictionary.getInstance(new File("src/main/resources/nounlist.txt"),"english-nouns");
	Set<Token> set = dic.findNouns(text);
	System.out.println("input: "+text);
	System.out.println("found: "+set);

FOR SCALA

  val text = "are there any doctors in the hospital this evening?"
  val dic = Dictionary.getInstance(new File("src/main/resources/nounlist.txt"), "english-nouns");
  val nouns = dic.findNouns(text)
  println("input: "+text)
  println("nouns: "+nouns)


version 0.1
Dictionary class provided.
