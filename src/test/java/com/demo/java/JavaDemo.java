package com.demo.java;
import java.io.File;
import java.util.Set;

import com.dsncode.scala.Dictionary;

public class JavaDemo {

	
	public static String reverse(String text)
	{
		return new StringBuilder(text).reverse().toString();
	}
	public static void main(String[] args) {

		Dictionary dic = new Dictionary("./src/main/resources/nounlist.txt");
		
		int x = 0;
		int fail =0;
		Set<String> set = dic.findNouns("he is an actor and he does not use underwear");
		System.out.println("found nouns: "+set);
		
	}

}
