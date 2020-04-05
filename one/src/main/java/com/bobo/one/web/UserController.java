package com.bobo.one.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bobo.one.domain.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/users")
@Api("User Inteferace")
public class UserController {


@ApiOperation("Get User by User Id")
@ApiParam(name="id",value="userId")
@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") Integer id){
		User user = new User();
		user.setId(id);
		user.setName("bobo huang");
		return user;
	}
@ApiOperation("Get all Users")
@RequestMapping(value="", method = RequestMethod.GET)
	public User[] getAllUser(){
	  List<User> users = new ArrayList<User>();	
	   User user = new User();
	   user.setId(100);
	   user.setName("bobo huang");
	   users.add(user);
	   return users.toArray(new User[users.size()]);
	}
}
