package com.bobo.one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.bobo.one.util.DingdingLogAppender;
import com.bobo.one.util.SpringContextUtil;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableFeignClients
//@ComponentScan(basePackages={"com.bobo.one.service","com.bobo.one.web"})
public class App 
{
	private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = SpringApplication.run(App.class, args);
        //DingdingLogAppender.setContext(context);
        //SpringContextUtil.setApplicationContext(context);
        logger.info("application started");
        System.out.println("std out:application started");
    }
}
