package com.digithkv.java.basics.multithreading;

public class ThreadExample {
	public static void main(String[] args) throws Exception {
		Thread t1 = new A();
		Thread t2 = new Thread(new B());
		t2.start(); // starts t2 thread
		t2.join(); // waits for the completion of t2 thread
		t1.start(); // starts t1 thread
		t1.join(); // waits for the completion of
		new Thread(() -> System.out.println(
				"This is annoymous thread using lamdba expression, name " 
						+ Thread.currentThread().getName()))
				.start(); // with lambda expressions using Runnable as functional interface
		Thread.currentThread().yield(); // allows threads with similar priority to run
	}
}

class A extends Thread { // Extending thread class
	public void run() {
		try {
			Thread.sleep(1000); // puts the thread to sleep for 1000ms ie 1s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("This is from class A, thread name " + Thread.currentThread().getName());
	}
}

class B implements Runnable { // Implementing Runnable interface
	public void run() {
		try {
			Thread.sleep(2000); // puts the thread to sleep for 2000ms ie 2s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("This is from class B , thread name " + Thread.currentThread().getName());
	}
}