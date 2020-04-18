package com.bobo.one.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bobo.one.domain.User;

@Component
@FeignClient(name = "testfeign", url = "${service.feign.url}")
public interface FeignService {

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") Integer id);
}
