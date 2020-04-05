package com.bobo.one.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.util.StringUtils;

import lombok.Data;
import lombok.NoArgsConstructor;


@MappedSuperclass
@Data
public class BasePojo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2810377533994050217L;
	private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="createdon")
	private Long createdon;
	@Column(name="lastupdatedon")
	private Long lastupdatedon;
	@Column(name="remarks",length=1000)
	private String remarks;
	
	
	public BasePojo(){
		this.createdon = System.currentTimeMillis();
		this.lastupdatedon = this.createdon;
	}
	
	public void AppendRemarks(String newRemarks){
		if(StringUtils.isEmpty(newRemarks))
			return;
		this.remarks = String.format("%s: %s\r\n;" + this.remarks, formatter.format(new Date()),newRemarks);
		if(!StringUtils.isEmpty(this.remarks) && this.remarks.length() > 500)
			this.remarks = this.remarks.substring(0,500);
	}

}
