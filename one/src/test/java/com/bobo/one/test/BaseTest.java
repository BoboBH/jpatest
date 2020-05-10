package com.bobo.one.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bobo.one.App;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class})
public class BaseTest {
	
	@Test
	public void assertTrue(){
		Assert.assertTrue(true);
	}

}
