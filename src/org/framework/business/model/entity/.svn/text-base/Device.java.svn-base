package org.framework.business.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//设备表 
@Entity
@Table(name="t_device")
public class Device  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1788573265467304551L;
	@Id
    @GeneratedValue
	private Long id;
	
	private String mac;//设备编号
	
	private String name;//设备名称
	
	private Long typeId;//所属分类ID
	
	private String typeName;//所属分类名称
	
	private String logo_path;//设备图标  从分类处获取
	
	private Long memberId;//所属会员Id  来自 memberId  1

	private String memName;//所属会员名称
	
	private String objMemId;//所有会员Id  _1_ _2_ _3_
	
	private int work_status;//工作状态  0空闲  1工作中
	
	private int status;//是否在线状态  0离线  1在线
	
	private Long herTime;//设备心跳时间
	
	private String ota_version;//固件版本号
	
	private Date addTime;

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getHerTime() {
		return herTime;
	}

	public void setHerTime(Long herTime) {
		this.herTime = herTime;
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

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjMemId() {
		return objMemId;
	}

	public void setObjMemId(String objMemId) {
		this.objMemId = objMemId;
	}

	public String getOta_version() {
		return ota_version;
	}

	public void setOta_version(String ota_version) {
		this.ota_version = ota_version;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getWork_status() {
		return work_status;
	}

	public void setWork_status(int work_status) {
		this.work_status = work_status;
	}
	
	
}


