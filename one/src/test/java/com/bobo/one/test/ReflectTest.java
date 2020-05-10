package com.bobo.one.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bobo.one.pojo.UBser;
import com.bobo.one.reflect.CSVField;
import com.bobo.one.reflect.ICSVConvert;
import com.bobo.one.reflect.ReflectUtils;

public class ReflectTest {
	
	@Test
	public void testGetCSVString(){
		UBser user = new UBser();
		user.setUsername("bobo huang");
		user.setAge(18);
		user.setPassword("791013");
		user.setSchoolId(Long.valueOf(100));
		List<String> fields = new ArrayList<String>();
		fields.add("username");
		fields.add("password");
		fields.add("schoolId");
		fields.add("age");
		String csvRow = ReflectUtils.getCSVRow(user, fields);
		Assert.assertNotNull(csvRow);
		String expectVal = "bobo huang\t791013\t100\t18";
		Assert.assertEquals(expectVal, csvRow);
	}
	
	@Test
	public void testAnnotation() throws NoSuchFieldException, SecurityException,Exception{
		UBser user = new UBser("bobo huang","", Long.valueOf(100),18);
		Field field = user.getClass().getDeclaredField("username");
	    field.setAccessible(true);
		CSVField csvField = field.getAnnotation(CSVField.class);
		Assert.assertNotNull(csvField);
		ICSVConvert convert =(ICSVConvert) csvField.convert().getConstructors()[0].newInstance(null);
		String name = convert.getValue(field.get(user));
		Assert.assertEquals("bobo huang", name);
	}
	
	@Test
	public void testGetCSVContent(){
		List<UBser> users = new ArrayList<>();
		users.add(new UBser("bobo huang","791013",Long.valueOf(100), 40));
		users.add(new UBser("happy huang","160404",Long.valueOf(100), 4));
		users.add(new UBser("sunny li","831128",Long.valueOf(100), 34));
		List<String> titles =new ArrayList<>();
		titles.add("User name");
		titles.add("Password");
		titles.add("school Id");
		titles.add("Age");
		titles.add("createdon");
		List<String> fields =new ArrayList<>();
		fields.add("username");
		fields.add("password");
		fields.add("schoolId");
		fields.add("age");
		fields.add("createdon");
		String content = ReflectUtils.getCSVContent(users,  fields, titles);
		System.out.println(content);
		Assert.assertNotNull(content);
		content = ReflectUtils.getCSVContent(users, fields, null);
		System.out.println(content);
		Assert.assertNotNull(content);
		
	}

}
