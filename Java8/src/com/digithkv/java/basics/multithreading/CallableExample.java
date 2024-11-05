package com.digithkv.java.basics.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> ft1 = new FutureTask<String>(new Callable1());
		new Thread(ft1).start();
		System.out.println("Using FutureTask for executing callable "+ft1.get());
		
		ExecutorService service = Executors.newCachedThreadPool();
		Future<String> submit = service.submit(new Callable1());
		System.out.println("Using ExecutorService for executing callable "+submit.get());
		
	}
}

class Callable1 implements Callable<String> {

	public String call() throws Exception {
		return "This is a callable return statement";
	}

}