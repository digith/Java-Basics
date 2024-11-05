package com.digithkv.java.basics.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService xService1 = Executors.newCachedThreadPool();
		ExecutorService xService2 = Executors.newSingleThreadExecutor();
		ExecutorService xService3 = Executors.newFixedThreadPool(2);
		ExecutorService xService4 = Executors.newScheduledThreadPool(3);
		Future future1 = xService1.submit(() -> {
							try {Thread.sleep(1000);
							}catch (InterruptedException e) {e.printStackTrace();}
							return "xService1 String";
						});
		Future future2 = xService1.submit(() -> {
							try {Thread.sleep(2000);
							} catch (InterruptedException e) {e.printStackTrace();}
							System.out.println("xService2 String");
						}); 
		xService3.execute(()-> {
			try {Thread.sleep(3000);
			} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println("xService3 String");
		});
		xService4.invokeAll(List.of(()->{return "this is ";},()->{return "for ";},()->{return "invokeAll";}))
		.stream().forEach(x->{try {System.out.print(x.get());
								  } catch (InterruptedException | ExecutionException e) {e.printStackTrace();}
							 }
						 );
		System.out.println();
		try(ExecutorService xService5 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());){
			String returnAny = xService5.invokeAny(List.of(()->{return "this is ";},
					()->{return "for ";},
					()->{return "invokeAny";}));
			System.out.println(returnAny);
		}
		System.out.println(future1.get());
		future2.get();
		xService1.shutdown();
		xService2.shutdown();
		xService3.shutdown();
		xService4.shutdown();
		
	}

}
