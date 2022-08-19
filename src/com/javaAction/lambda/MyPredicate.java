package com.javaAction.lambda;

import java.util.function.Predicate;

public class MyPredicate implements Predicate<Apple> {

	@Override
	public boolean test(Apple t) {
		return t.getWeight() > 20;
	}

	

}
