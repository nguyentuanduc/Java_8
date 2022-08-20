package com.javaAction.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyMain {

	public static void main(String[] args) {
		
		testMethodReferenceType();
	}
	
	
	public static void testMethodReferenceStatic() {
		List<Apple> appleList = initDate();
		
		
		for(Apple a : appleList) {
			System.out.print(" " + a.getWeight());
		}
		System.out.println();
		
		Collections.sort(appleList, (Apple::comparing));
		for(Apple a : appleList) {
			System.out.print(" " + a.getWeight());
		}
	}
	
	public static void testMethodReferenceObject() {
		List<Apple> appleList = initDate();
		for(Apple a : appleList) {
			System.out.print(" " + a.getWeight());
		}
		System.out.println();
		
		Apple apple = new Apple(null);
		List<Integer> apples = mapMethodReference(appleList, apple::doubleWeight);

		for(Integer a : apples) {
			System.out.print(" " + a);
		}
		System.out.println();
	}
	
	
	public static void testMethodReferenceType() {
		List<Apple> appleList = initDate();
		appleList.forEach(System.out::println);
	}
	
	public void testBufferedReader() {
		try {
			String text = processFile((BufferedReader br) -> br.readLine() + br.readLine());
			System.out.println(text);
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("/home/javahero/Documents/repositories/JavaVersion_8/Java_8/src/com/javaAction/lambda/datatest.txt"))) {
				return p.process(br);
		}
	}
	
	
	
	
	
	
	public static void  testComsumer()
	{
		List<Apple> appleList = initDate();
		for(Apple a : appleList) {
			System.out.print(" " + a.getWeight());
		}
		System.out.println();
		//forEach(appleList, (Apple a) -> a.setWeight(a.getWeight()*2));
		MyComsumer mc =  new MyComsumer();
		forEach(appleList, (Apple a) -> mc.accept(a));
		for(Apple a : appleList) {
			System.out.print(" " + a.getWeight());
		}
	}
	
	public static void  testPredicate()
	{
		List<Apple> appleList = initDate();
		
		List<Apple> result = new ArrayList<>();
		//result = filter(appleList, (Apple a) -> a.getWeight() > 50);
		MyPredicate mp = new MyPredicate();
		result = filter(appleList, (Apple p) -> mp.test(p));

		for(Apple a : result) {
			System.out.print(" " + a.getWeight());
		}
		//result = filter(appleList, new MyPredicate());
		for(Apple a : result) {
			System.out.print(" " + a.getWeight());
		}
	}
	public void testComparator() {
		Comparator<Apple> byWeight = new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
			
		};
		
		 List<Apple> appleList = initDate();
		
		
		for(Apple a : appleList) {
			System.out.print(" " + a.getWeight());
		}
		System.out.println();
		// Collections.sort(appleList, new MyComparator());
		Collections.sort(appleList, (Apple ap1, Apple ap2) -> ap1.getWeight().compareTo(ap2.getWeight()));
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
	
	public static void  testFunction()
	{
		 List<Apple> appleList = initDate();
		 List<String> result = map(appleList, (Apple a) -> a.getWeight().toString());
		 for(String a : result) {
				System.out.print(" " + a);
			}
	}
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f)
	{
		List<R> result = new ArrayList<>();
		for(T s : list)
		{
			result.add(f.apply(s));
		}
		return result;
	}
	
	public static <T, R> List<R> mapMethodReference(List<T> list, Function<T, R> f)
	{
		List<R> result = new ArrayList<>();
		for(T s : list)
		{
			result.add(f.apply(s));
		}
		return result;
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c)
	{
		for(T i: list) {
			c.accept(i);
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
	
	
	public static List<Apple>  initDate(){
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
		
		return appleList;
	}
	
}
