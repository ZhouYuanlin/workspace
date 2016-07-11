package com.atguigu.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;



public class StatciCarFactory {

	private static Map<String , Car> cars = new HashMap<String,Car>();
	static{
		cars.put("audi", new Car("audi", 30000));
		cars.put("ford", new Car("ford", 40000));		
	}
	
	public static Car getCar(String name){
		return cars.get(name);
	}
}
