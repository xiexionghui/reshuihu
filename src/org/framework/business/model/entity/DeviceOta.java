package org.framework.business.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//设备分类固件表 
@Entity
@Table(name="t_deviceota")
public class DeviceOta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1788573265467304551L;
	@Id
    @GeneratedValue
	private Long id;
	
	private String name;//固件名称
	
	private String d_path;//固件地址
	
	private String d_version;//固件版本号
	
	private Date addTime;
	
	private Long typeId;//设备分类ID
	
	private String typeName;//分类名称

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getD_path() {
		return d_path;
	}

	public void setD_path(String d_path) {
		this.d_path = d_path;
	}

	public String getD_version() {
		return d_version;
	}

	public void setD_version(String d_version) {
		this.d_version = d_version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
