package com.demo.java;
import java.io.File;
import java.util.Set;

import com.dsncode.nlp.analyser.Dictionary;
import com.dsncode.nlp.analyser.bean.Token;

/**
 * @author daniel silva navarro
 * web www.dsncode.com
 */
public class JavaDemo {

	public static void main(String[] args) {

		String text = "are there any doctors in the hospital this evening?";
		Dictionary dic = Dictionary.getInstance(new File("src/main/resources/nounlist.txt"),"english-nouns");
		Set<Token> set = dic.findNouns(text);
		System.out.println("input: "+text);
		System.out.println("found: "+set);
		
	}

}
