package com.javaAction.lambda;

import java.util.function.Consumer;

public class MyComsumer<T> implements Consumer<T>{

	
	@Override
	public void accept(T t) {
		System.out.print(t.toString());
	}

}
