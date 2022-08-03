package com.java8.lambdaExpressions;

public class Greeting {

	private static String text = "Hello, ";

	public static void main(String[] args) {
		text = "Hi, ";
		GreetingService greeting = message -> System.out.print(text + message);
		greeting.say("Jack");
	}

	interface GreetingService {
		void say(String message);
	}
}
