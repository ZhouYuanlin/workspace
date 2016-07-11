package com.atguigu.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("atguigu¹þ¹þ");
		helloWorld.hello();
		*/
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
		Car car = (Car)ctx.getBean("car");
		System.out.println(car);
//		helloWorld.hello();
		
		Car car1 = (Car)ctx.getBean("car1");
		System.out.println(car1);
		
		Person person = (Person)ctx.getBean("person2");
		System.out.println(person);
	}

}
