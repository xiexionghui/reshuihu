package org.framework.business.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//设备分类表 
@Entity
@Table(name="t_devicetype")
public class DeviceType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1788573265467304551L;
	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	private String logo_path;//设备分类图标
	
	private String d_no;//分类编号
	
	private String remark;
	
	private Date addTime;
	
	private int mode_count;//模式数量

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getD_no() {
		return d_no;
	}

	public void setD_no(String d_no) {
		this.d_no = d_no;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMode_count() {
		return mode_count;
	}

	public void setMode_count(int mode_count) {
		this.mode_count = mode_count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}
	

}
