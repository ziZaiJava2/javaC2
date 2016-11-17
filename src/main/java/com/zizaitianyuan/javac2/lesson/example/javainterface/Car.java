package com.zizaitianyuan.javac2.lesson.example.javainterface;

public class Car implements Vehicle {

	Driver driver;

	@Override
	public void setDriver(Driver driver) {
		this.driver = driver;

	}

	@Override
	public int getSeatNumber() {
		return 4;
	}

	@Override
	public void drive() {
		if (driver == null) {
			System.out.println("no driver");
		} else {
			driver.driveCar();
		}
	}
}
