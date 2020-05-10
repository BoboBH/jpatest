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

import com.bobo.one.reflect.CSVField;
import com.bobo.one.reflect.TimeStampConvert;

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
	protected Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Long createdon) {
		this.createdon = createdon;
	}

	public Long getLastupdatedon() {
		return lastupdatedon;
	}

	public void setLastupdatedon(Long lastupdatedon) {
		this.lastupdatedon = lastupdatedon;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@CSVField(value="Created On",convert = TimeStampConvert.class)
	@Column(name="createdon")
	protected Long createdon;
	@Column(name="lastupdatedon")
	protected Long lastupdatedon;
	@Column(name="remarks",length=1000)
	protected String remarks;
	
	
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
