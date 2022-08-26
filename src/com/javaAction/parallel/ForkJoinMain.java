package com.javaAction.parallel;

import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ForkJoinMain {

	
	
	public static void main(String[] args) {
		//System.out.println(measureSumPerf(ForkJoinSumCaculator::forkJoinSum, 100000));
		final String SENTENCE = " Nel mezzo del cammin di nostra vita " +
				"mi ritrovai in una selva oscura" + 
				" ché la dritta via era smarrita ";
		Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
		System.out.println("count " + countWords(stream));
		
		Stream<Character> streamParallel = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
		System.out.println("count " + countWords(streamParallel.parallel()) );
		
		
		Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> streamSpliterator = StreamSupport.stream(spliterator, true);
		System.out.println("count " + countWords(streamSpliterator));

	}
	
	private static int countWords(Stream<Character> stream) {
		WordCounter word = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		return word.getCounter();
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
	
	public int countWordsIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace) counter++;
				lastSpace = false;
			}
		}
		
		return counter;
	}
	
}






















