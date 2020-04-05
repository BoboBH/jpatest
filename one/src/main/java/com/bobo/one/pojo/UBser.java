package com.bobo.one.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="t_user")
public class UBser extends BasePojo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6726305801877898117L;
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

	public UBser(){
		super();
	}
}
