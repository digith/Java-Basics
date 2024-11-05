package com.digithkv.java.basics.designpatterns.creational;

enum CarType {
	SMALL, MEDIUM, LARGE
}

interface Car {
	void startCar();
}

class SmallCar implements Car {
	public void startCar() {
		System.out.println("Rom.. rom.. Tata nano incoming");
	}
}

class MediumCar implements Car {
	public MediumCar() {
		//write complicate logic
	}
	public void startCar() {
		System.out.println("Pe..pee.. Sedan incoming");
	}
}

class LargeCar implements Car {
	public void startCar() {
		System.out.println("Boom.. Boom.. Is this a car or van");
	}
}

class CarFactory {
	public Car createCar(CarType type) {
		switch (type) {
			case SMALL:
				return new SmallCar();
			case MEDIUM:
				return new MediumCar();
			case LARGE:
				return new LargeCar();
			default:
				throw new IllegalArgumentException("Invalid car type: " + type);
		}
	}
}

public class FactoryDesignPattern {
	public static void main(String[] args) {
		CarFactory factory = new CarFactory();
		Car car = factory.createCar(CarType.MEDIUM);
		car.startCar();
	}
}
