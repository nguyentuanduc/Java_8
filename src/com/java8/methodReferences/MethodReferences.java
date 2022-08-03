package com.java8.methodReferences;

import java.util.ArrayList;
import java.util.List;

public class MethodReferences {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		
		names.add("Eric");
		names.add("Danny");
		names.add("Carlo");
		names.add("Billy");
		names.add("Anna");
		
		names.forEach(System.out::println);
		
		
	}

}
