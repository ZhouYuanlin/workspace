package com.atguigu.spring.bean.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("AfterInit..."+bean+","+beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean	, String beanName) throws BeansException {
		System.out.println("BeforeInit..." + bean+","+beanName);
		return bean;
	}

}
