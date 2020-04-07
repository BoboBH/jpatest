package com.bobo.one.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobo.one.domain.User;
import com.bobo.one.service.FeignService;

@RestController
@RequestMapping("/")
public class TestController {
	@Autowired
	private FeignService feignService;
	@RequestMapping("/test/{id}")
	public User getUser(@PathVariable("id") Integer id){
		return feignService.getUser(id);
	}

}
