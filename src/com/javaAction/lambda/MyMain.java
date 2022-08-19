package com.javaAction.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MyMain {

	public static void main(String[] args) {
		
		Apple a1 = new Apple(1);
		Apple a2 = new Apple(12);
		Apple a3 = new Apple(31);
		Apple a4 = new Apple(14);
		Apple a5 = new Apple(51);
		Apple a6 = new Apple(16);
		Apple a7 = new Apple(71);
		
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(a1);
		appleList.add(a2);
		appleList.add(a3);
		appleList.add(a4);
		appleList.add(a5);
		appleList.add(a6);
		appleList.add(a7);
		
		List<Apple> result = new ArrayList<>();
		result = filter(appleList, new MyPredicate());
		
		for(Apple a : result) {
			System.out.print(" " + a.getWeight());
		}
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T s: list) {
			if(p.test(s)) {
				result.add(s);
			}
		}
		return result;
	}
	
	
	public void testComparator() {
		Comparator<Apple> byWeight = new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
			
		};
		
		
		Apple a1 = new Apple(1);
		Apple a2 = new Apple(12);
		Apple a3 = new Apple(31);
		Apple a4 = new Apple(14);
		Apple a5 = new Apple(51);
		Apple a6 = new Apple(16);
		Apple a7 = new Apple(71);
		
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(a1);
		appleList.add(a2);
		appleList.add(a3);
		appleList.add(a4);
		appleList.add(a5);
		appleList.add(a6);
		appleList.add(a7);
		
		for(Apple a : appleList) {
			System.out.print(" " + a.getWeight());
		}
		System.out.println();
		// Collections.sort(appleList, new MyComparator());
		// Collections.sort(appleList, (Apple ap1, Apple ap2) -> ap1.getWeight().compareTo(ap2.getWeight()));
		Collections.sort(appleList, new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
			
		});
		
		for(Apple a : appleList) {
			System.out.print(" " + a.getWeight());
		}
	}
	
}
