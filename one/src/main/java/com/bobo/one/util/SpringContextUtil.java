package com.bobo.one.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	
	@Override
	public  void setApplicationContext(ApplicationContext context){
		applicationContext = context;
	}
	
	public static <T> T getBean(Class<T> clazz){
		
		if(applicationContext == null)
			return null;
		return applicationContext.getAutowireCapableBeanFactory().getBean(clazz);
	}

}
