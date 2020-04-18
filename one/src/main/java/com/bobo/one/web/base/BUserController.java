package com.bobo.one.web.base;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bobo.one.dao.UserReportRepository;
import com.bobo.one.dao.UserRepository;
import com.bobo.one.pojo.UBser;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/base/users")
@Api(value="Base User API; Operate user through by database")
public class BUserController {

	@Autowired
	private UserRepository userRepository;
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public UBser getUser(@PathVariable("id") Long id){
		
		Optional<UBser> result = userRepository.findById(id);
		if(result.isPresent())
			return result.get();
		return null;
	}
	
	@RequestMapping(value="/", method= RequestMethod.POST)
	public boolean CreateUser(@RequestBody UBser user){
		user.AppendRemarks("created");
		userRepository.save(user);
		return true;
	}
}
