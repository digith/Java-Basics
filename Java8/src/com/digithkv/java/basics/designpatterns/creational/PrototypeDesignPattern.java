package com.digithkv.java.basics.designpatterns.creational;

interface Shape {
	Shape clone();
	void draw();
}

class Circle implements Shape, Cloneable {
	private String color;
	public Circle(String color) {
		this.color = color;
	}
	public Shape clone() {
		return new Circle(this.color);
	}
	public void draw() {
		System.out.println("Drawing a " + color + " circle.");
	}
}

class ShapeClient {
	private Shape shapePrototype;
	public ShapeClient(Shape shapePrototype) {
		this.shapePrototype = shapePrototype;
	}
	public Shape createShape() {
		return shapePrototype.clone();
	}
}

public class PrototypeDesignPattern {
	public static void main(String[] args) {
		Shape circlePrototype = new Circle("red");
		ShapeClient client = new ShapeClient(circlePrototype);
		Shape redCircle = client.createShape();
		redCircle.draw();
	}
}
