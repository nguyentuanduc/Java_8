package com.javaAction.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCaculator extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final long[] numbers;
	private final int start;
	private final int end;
	
	public static final long THRESHOLD = 10000;

	public ForkJoinSumCaculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}

	
	private ForkJoinSumCaculator(long[] numbers, int start, int end) {
		super();
		this.numbers = numbers;
		this.start = 0;
		this.end = numbers.length;
	}
	
	@Override
	protected Long compute() {
		int length = start - end;
		if(length <= THRESHOLD) {
			return computeSequentially();
		}
		ForkJoinSumCaculator leftTask = new ForkJoinSumCaculator(numbers, start, start + length/2);
		leftTask.fork();
		
		ForkJoinSumCaculator rightTask = new ForkJoinSumCaculator(numbers, start + length/2, end);
		Long rightResult = rightTask.compute();
		Long leftresult  = leftTask.join();
		
		return leftresult + rightResult;
	}
	
	private long computeSequentially() {
		long sum = 0;
		for(int  i = start; i <  end; i++) {
			sum += numbers[i];
		}
		
		return sum;
	}
	
	public static long forkJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCaculator(numbers);
		return new ForkJoinPool().invoke(task);
		
	}
}
