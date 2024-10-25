package com.digithkv.sample;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		// static method invoking
		SampleFunctionalInterface.printDummyText();
		// default method invoking
		(new SampleFunctionalInterfaceImpl()).returnDefaultText();		
		// Defining Lambda expression for Functional Interface definition
		SampleFunctionalInterface<String,Double,String> sfi = (a,b) ->  a+b;
		// invoking SAM Interface method
		System.out.println(sfi.add("Function Interface with lambda expression was introduced in java version ", 1.8));
	}
}

class SampleFunctionalInterfaceImpl implements SampleFunctionalInterface {
	// Old way of defining
	public Object add(Object t, Object u) { return t.toString() + u.toString(); }
}

@FunctionalInterface // optional annotation
interface SampleFunctionalInterface<T, U, Q> { // Also called SAM interface - Single Abstract method interface
	Q add(T t, U u); // abstract method
	// static method
	static void printDummyText() {
		System.out.println("Static Method in java was introduced in 1.8");
	}
	//default method
	default void returnDefaultText() {
		System.out.println("Default methods in java was introduced in 1.8");
	}
}