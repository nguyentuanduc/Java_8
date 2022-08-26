package com.javaAction.parallel;

import java.util.function.Function;
import java.util.stream.Stream;

public class Parallel {

	public static void main(String[] args) {
		System.out.println(1L);
		long result = measureSumPerf(Parallel::sequentialSum, 10000000);	
		System.out.println(measureSumPerf(Parallel::iterativeSum, 10000000));
		System.out.println(measureSumPerf(Parallel::parallelSum, 10000000));
	}

	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i+1).limit(n).reduce(0L, Long::sum);
	}
	
	public static long iterativeSum(long n) {
		long result = 0;
		for(long i = 1L; i <= n; i++) {
			result += i;
		}
		return result;
	}
	
	
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
	
	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for(int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start)/1000000;
			System.out.println("Result : " + sum);
			if(duration < fastest) fastest = duration;
		}
		
		return fastest;
	}
}





















