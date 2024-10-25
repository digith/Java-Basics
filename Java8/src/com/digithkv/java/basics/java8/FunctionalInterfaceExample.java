package com.digithkv.java.basics.java8;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		// Functional Interface - static method invoking
		SampleFunctionalInterface.printDummyText();
		
		// Functional Interface - default method invoking
		(new SampleFunctionalInterfaceImpl()).returnDefaultText();
		
		// Lambda expression for Functional Interface definition
		SampleFunctionalInterface<String, Double, String> sfi = (a, b) -> a + b;
		
		// Invoking SAM interface method
		System.out.println(sfi.add("Functional Interface with lambda expression was introduced in java version ", 1.8));
		
		System.out.println(new SampleFunctionalInterfaceImpl().add("Functional Interfaces can also be overrided ", "as normal interfaces"));
	}
}

class SampleFunctionalInterfaceImpl implements SampleFunctionalInterface {
	public Object add(Object t, Object u) { // Old way of doing
		return t.toString() + u.toString();
	}
}

@FunctionalInterface // optional annotation
interface SampleFunctionalInterface<T, U, Q> { // Also called SAM interface - Single Abstract method interface
	Q add(T t, U u); // abstract method
	// static method

	static void printDummyText() {
		System.out.println("Static Method in java was introduced in 1.8");
	}

	// default method
	default void returnDefaultText() {
		System.out.println("Default methods in java was introduced in 1.8");
	}
}