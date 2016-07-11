package com.atguigu.spring.bean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.bean.autowire.*;


public class Main {

	public static void main(String [] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
		Car car = (Car)ctx.getBean("car");
		Car car2= (Car)ctx.getBean("car");
		System.out.println(car==car2);
	}

}
