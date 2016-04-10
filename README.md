# DictionaryTokenizer

Given a txt dictionary, this api can help you to find out these words in a given text.

EXAMPLE: (given a english-nouns.txt file):
input: are there doctors in the hospital?
output: [doctors, hospital]

USAGE:

public static void main(String[] args) {

		Dictionary dic = new Dictionary("./src/main/resources/nounlist.txt");  // give the path to your dictionary.txt file
		Set<String> set = dic.findNouns("are there doctors in the hospital?"); // tell your dictionary your text to analyze
		System.out.println("founds: "+set); // print the response
		
	}

version 0.1
SimpleDictionary provided.
