package com.bobo.one.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobo.one.App;
import com.bobo.one.config.AppConfig;
import com.bobo.one.domain.User;
import com.bobo.one.service.FeignService;
import com.bobo.one.util.SpringContextUtil;

@RestController
@RequestMapping("/")
public class TestController {

	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private FeignService feignService;
	@RequestMapping("/test/{id}")
	public User getUser(@PathVariable("id") Integer id){
		logger.info("get user by id " + id);
		AppConfig appConfig = SpringContextUtil.getBean(AppConfig.class);
		if(appConfig != null)
			logger.info("retrieved appconfig from springcontextutil");
		return feignService.getUser(id);
	}

}
