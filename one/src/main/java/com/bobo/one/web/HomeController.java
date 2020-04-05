package com.bobo.one.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


@Api("Home API")
@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(){
		return "Welcome Visit one";
	}
}
