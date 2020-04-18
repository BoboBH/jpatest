package com.bobo.one.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bobo.one.config.AppConfig;

import io.swagger.annotations.Api;


@Api("Home API")
@RestController
@RequestMapping("/")
public class HomeController {

	 @Autowired
	 private AppConfig config;
	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${default.value:default}")
	private String defaultValue;
	
	@RequestMapping(value="/config", method = RequestMethod.GET)
	public AppConfig getConfig(){
		return this.config;
	}
	
	@RequestMapping(value="/default", method = RequestMethod.GET)
	public String getDefault(){
		return this.defaultValue;
	}
	@RequestMapping(value="/name", method=RequestMethod.GET)
	public String getAppName(){
		return this.appName;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(){
		return "Welcome Visit one";
	}
}
