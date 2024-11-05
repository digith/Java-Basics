package com.digithkv.java.basics.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObserverDesignPattern {
	public static void main(String[] args) {
		
	}
}

class Publisher{
	private static HashMap<String, List<Subscriber>> pubSubMap = new HashMap<String, List<Subscriber>>();
	private void notifySubscriber(String videoName, String channel) {
		for(Subscriber subscriber: pubSubMap.get(channel)) {
			subscriber.getNotified(videoName,channel);
		}
	}
	public Publisher(List<String> channels){
		for(String channel:channels)
		pubSubMap.putIfAbsent(channel, new ArrayList<Subscriber>());
	}
	public void uploadVideo(String videoName,String channel) {
		notifySubscriber(videoName,channel);
	}
	public static void getsubscribed(Subscriber subscriber, String channel) {
		pubSubMap.putIfAbsent(channel,new ArrayList<Subscriber>());
		pubSubMap.get(channel).add(subscriber);
	}
}

class Subscriber{
	private String name;
	@SuppressWarnings("unused")
	private void subscribe(String channel) {
		Publisher.getsubscribed(this, channel);
	}
	public void getNotified(String videoName, String channel) {
		System.out.println("Hey "+this.name+", channel "+channel+" has a new video "+videoName);
	}
}