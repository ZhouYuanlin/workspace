package com.atguigu.spring.bean.factory;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");
		Car car = (Car)ctx.getBean("car2");
		System.out.println(car);
		
	}

}
