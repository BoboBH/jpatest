package com.bobo.one.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import lombok.Data;

@Entity
@Data
@Immutable
@Subselect("select * from uvw_user ")
//@Subselect(value="select *, 'sch_name' as school_name, 'addr' as school_address from t_user")
//@NamedNativeQuery(name = "t_user_report", resultClass = UserReport.class, query = "select *, 'sch_name' as school_name, 'addr' as school_address from t_user")
//@Synchronize({"t_user"})
public class UserReport{
	@Id
	@Column(name="id")
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	@Column(name="school_name")
	private String schoolName;
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	@Column(name="school_address")
	private String schoolAddress;
	

	@Column(name="age")
	private Integer age;
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
