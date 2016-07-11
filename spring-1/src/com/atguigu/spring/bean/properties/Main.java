package com.atguigu.spring.bean.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

import javax.sql.*;
 

public class Main {

	public static void main(String [] args) throws SQLException {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

}
