package com.digithkv.java.basics.java8;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		Optional optString = Optional.of("user1");
		System.out.println("Optional isPresent "+optString.isPresent());
		System.out.println("Optional get "+optString.get());
		try {
			optString = Optional.of(null);
		}catch(Exception e) {System.out.println("Exception e "+e);}
		optString = Optional.ofNullable(null);
		System.out.println("Optional orElse "+optString.orElse("SomeString"));
		System.out.println("Optional or "+optString.or(()->"SomeString"));
		
	}
}
