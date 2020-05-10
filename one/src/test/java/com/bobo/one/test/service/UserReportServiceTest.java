package com.bobo.one.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bobo.one.dao.UserReportRepository;
import com.bobo.one.pojo.UserReport;
import com.bobo.one.service.UserReportService;
import com.bobo.one.test.BaseTest;


public class UserReportServiceTest extends BaseTest{
	
	@Autowired
	private UserReportService userReportService;
	
	@Test
	public void testGetAll(){
		 
		List<UserReport> list = userReportService.getAllUserReport();
		Assert.assertTrue(list.size() > 0);
		String name = "bobo%";
		List<UserReport> tt = userReportService.search(name, null,  null, null);
		Assert.assertTrue(tt.size() > 0);

		tt = userReportService.search(name, "%Guarden%",  null, null);
		Assert.assertTrue(tt.size() > 0);
		tt = userReportService.search(null, null,Integer.valueOf(30), null);
		Assert.assertTrue(tt.size() > 0);
		tt = userReportService.search(null, null,Integer.valueOf(30), Integer.valueOf(40));
		Assert.assertTrue(tt.size() > 0);
	}

}
