package com.digithkv.java.basics.designpatterns.structrual;

import java.util.HashMap;

public class FlyweightDesignPattern {
	public static void main(String[] args) {
		Circle circle1  =ShapeFactory.getCircle("Pink");
		circle1.setRadius(10);
		circle1.setX(1);
		circle1.setY(8);
		circle1.draw();
		Circle circle2  =ShapeFactory.getCircle("Pink");
		circle2.setRadius(8);
		circle2.setX(2);
		circle2.setY(2);
		circle2.draw();
	}
}

interface Shape{
	void draw();
}

class Circle implements Shape{
	//extrinsic
	private int x , y;
	private float radius;
	//intrinsic
	private String color;
	public Circle(String color) {
	}
	public void draw() {
		System.out.println("Circle drawn with radius "+radius+"\nx: "+x+" :: y:"+y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}

class ShapeFactory {
	private static final HashMap<String, Circle> circleMap = new HashMap<String, Circle>();
	public static Circle getCircle(String color){
		Circle circle = circleMap.get(color);
		if(circle==null) {
			circle = new Circle(color);
			circleMap.put(color, circle);
		}
		return circle;
	}
}