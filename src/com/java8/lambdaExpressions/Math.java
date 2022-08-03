package com.java8.lambdaExpressions;

public class Math {

	public static void main(String[] args) {

		Math math = new Math();
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (int a, int b) -> a - b;
		MathOperation multiplication = (int a, int b) -> {return a * b;};
		MathOperation division = (int a, int b) -> a / b;
		
	      System.out.println("15 + 5 = " + math.operate(15, 5, addition));
	      System.out.println("15 - 5 = " + math.operate(15, 5, subtraction));
	      System.out.println("15 * 5 = " + math.operate(15, 5, multiplication));
	      System.out.println("15 / 5 = " + math.operate(15, 5, division));

	}

	interface MathOperation {
		int operation(int a, int b);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
