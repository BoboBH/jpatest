package com.bobo.one.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bobo.one.reflect.CSVBaseConvert;
import com.bobo.one.reflect.CSVField;


@Entity
@Table(name="t_user")
public class UBser extends BasePojo{
	
	public UBser(String username, String password,Long schoolId, Integer age){
		super();
		this.username = username;
		this.age = age;
		this.password = password;
		this.schoolId = schoolId;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6726305801877898117L;
	@CSVField(value="User Name",convert = CSVBaseConvert.class)
	@Column(name="username")
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password")
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="lastloginon")
	private Long lastloginon;
	public Long getLastloginon() {
		return lastloginon;
	}
	public void setLastloginon(Long lastloginon) {
		this.lastloginon = lastloginon;
	}

	@Column(name="school_id")
	private Long schoolId;
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	
	@Column(name="age")
	private Integer age;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public UBser(){
		super();
	}
}
