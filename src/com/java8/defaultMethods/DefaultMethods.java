package com.java8.defaultMethods;

public class DefaultMethods {

	public static void main(String[] args) {
		Vehicle vehicle = new Car();
		vehicle.print();
	}

	
}

interface Vehicle {
	default void print() {
		System.out.println("I am a vehicle");
	}
	
	static void blowHorn() {
		System.out.println("Blowing Horn");
	}
}

interface FourWheeler {
	default void print() {
		System.out.println("I am a Four Wheeler");
	}
}

class Car implements Vehicle, FourWheeler {

	@Override
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("I am a Car");
	}
	
}