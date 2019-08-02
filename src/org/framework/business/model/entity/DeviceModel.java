package org.framework.business.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//设备模式表 
@Entity
@Table(name="t_devicemodel")
public class DeviceModel  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1788573265467304551L;
	@Id
    @GeneratedValue
	private Long id;
	
	private String logo_path;//图片
	
	private String name;//模式名称
	
	private Long typeId;//所属设备分类ID
	
	private String typeName;//所属分类名称
	
	private String remark;//配方
	
	private Date addTime;

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogo_path() {
		return logo_path;
	}

	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
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
