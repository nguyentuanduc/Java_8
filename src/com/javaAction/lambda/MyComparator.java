package com.javaAction.lambda;

import java.util.Comparator;

public class MyComparator implements Comparator<Apple> {

	@Override
	public int compare(Apple o1, Apple o2) {
		return o1.getWeight().compareTo(o2.getWeight());
	}

}
