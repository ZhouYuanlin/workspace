package com.atguigu.spring.bean.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
		Car car = (Car)ctx.getBean("car");
		System.out.println(car);
		ctx.close();
	}

}
