package com.java8.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsList {

	public static void main(String[] args) {

		List<String> lists = Arrays.asList("Anna","Jack", "", "John","Cary");
		lists.forEach(System.out::println);
		List<String> listsFilter = lists.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		listsFilter.forEach(System.out::println);

		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		numbers.forEach(System.out::print);
		System.out.println("");
		List<Integer> numbersPlus =numbers.stream().map(i -> i + 1).collect(Collectors.toList());
		numbersPlus.forEach(System.out::print);
		System.out.println("");
		List<Integer> numbersLimit = numbers.stream().limit(3).collect(Collectors.toList());
		numbersLimit.forEach(System.out::print);
		System.out.println("");
		List<Integer> numbersSort = numbers.stream().sorted().collect(Collectors.toList());
		numbersSort.forEach(System.out::print);
		System.out.println("");

		
		long count = lists.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("count " + count);

	}

}














