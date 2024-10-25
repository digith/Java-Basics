package com.digithkv.java.basics.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSample {
	public static void main(String[] args) {
		// Simple Stream operation to find sum of number 1 - 100
		System.out.println(IntStream.rangeClosed(1, 100).sum());

		// Sample Stream operations
		Arrays.asList(0l, "1", "2", 3, 4, 5).stream().map(i -> Integer.valueOf(String.valueOf(i)) + 1)
				.forEach(System.out::println);
		System.out.println(Stream.of("user1", "user2", "user2", 1, 24l, 1.8, null).filter(i -> (i instanceof Long))
				.findAny().get());

		// Fibonacci Series Example
		Stream.iterate(new int[] { 0, 1 }, p -> new int[] { p[1], p[0] + p[1] }).limit(10).map(n -> n[0])
				.forEach(System.out::println);

		// First repeating character in a String
		System.out.println("First repeating character in a String 'heymynameisreallyboring' is "
				+ "heymynameisreallyboring".chars().mapToObj(c -> (char) c)
						.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
						.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).findFirst().get());
	}
}
