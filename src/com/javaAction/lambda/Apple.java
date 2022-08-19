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

    
	

	@Override
	public String toString() {
		return "Apple [weight=" + weight + "]";
	}
}
