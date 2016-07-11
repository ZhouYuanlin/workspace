package com.atguigu.spring.bean.factory; 

public class Car {
	
	

	public Car(String brand, double price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	private String brand;
	private double price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}
	
}
