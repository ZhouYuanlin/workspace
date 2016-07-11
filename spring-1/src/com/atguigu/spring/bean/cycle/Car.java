package com.atguigu.spring.bean.cycle;

public class Car {
	public Car(){
		System.out.println("Car's constructor");
	}
	
	public String brand;

	public void setBrand(String brand) {
		System.out.println("Setter...");
		this.brand = brand;
	}
	
	public void Init(){
		System.out.println("init...");
	}
	
	public void destory(){
		System.out.println("destory...");
	}
}
