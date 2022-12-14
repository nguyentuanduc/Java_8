package com.javaAction.lambda;


public class Apple {

	private Integer weight;
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Apple(Integer weight) {
		this.weight = weight;
	}

	public static int comparing(Apple a1, Apple a2) {
		return a1.getWeight().compareTo(a2.getWeight());
	}

	public int doubleWeight(Apple a1) {
		return a1.getWeight()*2;
	}
	
	
	@Override
	public String toString() {
		return "Apple [weight=" + weight + "]";
	}
}
