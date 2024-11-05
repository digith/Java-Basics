package com.digithkv.java.basics.java8;

import java.util.concurrent.*;

public class CompletableFutureSample {
	public static void main(String[] args) throws Exception {
		CompletableFuture.runAsync(()->{// runAsync takes runnable as input
			try {Thread.currentThread().sleep(2000);}catch (InterruptedException e){e.printStackTrace();} 
			System.out.println("Hello World");});
		// Consider a Payment scenario after making a payment sending mail, message,
		// app-notification can be done asynchronous.
		Notification n1 = new Notification();
		CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {
			new Thread(new Mail(n1)).start(); return n1;
		}).thenApply(n2 -> { // thenApply takes Function as input
			new Thread(new Message(n2)).start(); return n2;
		}).thenAccept(n3 -> { // thenAccept takes Consumer as input
			new Thread(new AppNotification(n3)).start();
		});
		System.out.println("Before sleep Notification status " + n1);
		Thread.sleep(2000);
		System.out.println("After sleep Notification status " + n1);

		// A call notification is also sent, if signal is not there exception is thrown and retry call
		CallNotification callNotification = new CallNotification();
		while(!CallNotification.getIsCalled()) {
			CompletableFuture<CallNotification> cn1 = CompletableFuture.supplyAsync(() -> {
				try (ExecutorService xService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
					return xService.submit(callNotification).get();
				} catch (InterruptedException | ExecutionException e) {throw new RuntimeException("Issue while calling " + e.getMessage());}
			}).exceptionally(e -> {
				System.out.println("Exceptionally block " + e.getMessage());
				return callNotification;
			});
			Thread.sleep(1000);
			callNotification.setIsSignal(true);
		}
	}
}

class Notification {
	private Boolean isMailSent = false;
	private Boolean isMessageSent = false;
	private Boolean isAppNotificationSent = false;

	public void setIsMailSent(Boolean isMailSent) {
		this.isMailSent = isMailSent;
	}

	public void setIsMessageSent(Boolean isMessageSent) {
		this.isMessageSent = isMessageSent;
	}

	public void setIsAppNotificationSent(Boolean isAppNotificationSent) {
		this.isAppNotificationSent = isAppNotificationSent;
	}

	@Override
	public String toString() {
		return "Notification [isMailSent=" + isMailSent + ", isMessageSent=" + isMessageSent
				+ ", isAppNotificationSent=" + isAppNotificationSent + "]";
	}

}

class Mail implements Runnable {
	Notification notification;

	public Mail(Notification notification) {
		this.notification = notification;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notification.setIsMailSent(true);
		System.out.println("Mail sent successfully");
	}
}

class Message implements Runnable {
	Notification notification;

	public Message(Notification notification) {
		this.notification = notification;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notification.setIsMessageSent(true);
		System.out.println("Message sent successfully");
	}
}

class AppNotification implements Runnable {
	Notification notification;

	public AppNotification(Notification notification) {
		this.notification = notification;
	}

	@Override
	public void run() {
		notification.setIsAppNotificationSent(true);
		System.out.println("App Notification sent successfully");
	}
}

class CallNotification implements Callable<CallNotification> {
	private static volatile Boolean isSignal = false;
	private static volatile Boolean isCalled = false;
	@Override
	public CallNotification call() throws Exception {
		if (CallNotification.isSignal == false) {
			throw new RuntimeException("Unable to call the receipent");
		}
		isCalled=true;
		Thread.currentThread().sleep(3500);
		System.out.println("Calling successfully");
		return this;
	}

	public Boolean getIsSignal() {
		return isSignal;
	}

	public void setIsSignal(Boolean isSignal) {
		this.isSignal = isSignal;
	}

	public static Boolean getIsCalled() {
		return isCalled;
	}

	public static void setIsCalled(Boolean isCalled) {
		CallNotification.isCalled = isCalled;
	}

}