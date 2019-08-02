package org.framework.business.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//管理员表 用户表 
@Entity
@Table(name = "t_user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1788573265467304551L;

	@Id
	@GeneratedValue
	private Long id;

	private String userName;// 账号

	private String password;// 密码

	private String nickName;// 昵称

	private String mobile;

	private String email;

	@Column(columnDefinition = "int default 0")
	private Long status; // 0、正常 1、禁用

	private String remark;

	private Date addTime;// 创建时间

	// 所属角色ID 支持多个角色，以逗号隔开
	@Column(length = 100)
	private String rid;

	private int is_admin;// 是否是超级管理员 0否 1是

	private int is_delete;// 是否删除 0否 1是

	private int admin_type;// 管理员类型 0后台管理员 1厂商管理员

	private Date loginTime;// 登录时间

	private String loginIp;// 登录IP

	private String companyNo;// 厂商编号

	private Long companyId;

	private String companyName;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public int getAdmin_type() {
		return admin_type;
	}

	public void setAdmin_type(int admin_type) {
		this.admin_type = admin_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
