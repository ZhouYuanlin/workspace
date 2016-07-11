package com.atguigu.spring.bean.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx =  new ClassPathXmlApplicationContext("applicationContext.xml");
//		Person person = (Person)ctx.getBean("person3");
//		System.out.println(person); 
		
		
		Person person2 = (Person)ctx.getBean("person6");
		System.out.println(person2);
		
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		System.out.println(dataSource.getProperties());
		
	}

}
