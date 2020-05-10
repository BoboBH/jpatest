package com.bobo.one.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.bobo.one.config.AppConfig;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

@Component
public class DingdingLogAppender extends UnsynchronizedAppenderBase<ILoggingEvent> implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	@Override
	protected void append(ILoggingEvent arg0) {
		// TODO Auto-generated method stub
		
		AppConfig appConfig = SpringContextUtil.getBean(AppConfig.class);
		if(appConfig == null)
			System.out.println("Dingding Appender:" + arg0.getMessage());
		else
			System.out.println("Dingding Appender of application " + appConfig.getAppName() + " " + arg0.getMessage());
		
	}

	public static <T> T getBean(Class<T> clazz){
		if(applicationContext == null)
			return null;
		return applicationContext.getAutowireCapableBeanFactory().getBean(clazz);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Set Application Context in Dingding Log Appender");
		applicationContext = context;
		
	}
	
	public static void setContext(ApplicationContext context){
		if(applicationContext == null)
			applicationContext = context;
	}

}
