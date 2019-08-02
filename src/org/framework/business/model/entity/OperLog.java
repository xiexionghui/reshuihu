package org.framework.business.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//操作日志表
@Entity
@Table(name="t_operlog")
public class OperLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838732995856086555L;
	@Id
    @GeneratedValue
    private Long id;
	
	private Long userId;//操作人
	
	private String userName;//操作人名称
	
	private String nickName;
	
	private Date addTime;
	
	private String one_menu;//一级菜单名
	
	private String two_menu;//二级菜单名
	
	private String content;//操作内容
	
	private String remark;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOne_menu() {
		return one_menu;
	}

	public void setOne_menu(String one_menu) {
		this.one_menu = one_menu;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTwo_menu() {
		return two_menu;
	}

	public void setTwo_menu(String two_menu) {
		this.two_menu = two_menu;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
