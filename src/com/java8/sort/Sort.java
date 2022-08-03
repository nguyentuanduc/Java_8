package com.java8.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

	public static void main(String[] args) {

		List<String> listName = new ArrayList<String>();
		listName.add("Eric");
		listName.add("Danny");
		listName.add("Carlo");
		listName.add("Billy");
		listName.add("Anna");
		
	    System.out.println(listName);
		Sort sort = new Sort();
		sort.sortUsingJava8(listName);
	    System.out.println(listName);

	}
	
	
	private void sortUsingJava8(List<String> list) {
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
	}

}
