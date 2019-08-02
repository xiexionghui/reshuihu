package org.framework.business.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_roleqx")
public class RoleQx implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838732995856086555L;
	@Id
    @GeneratedValue
    private Long id;
	
	//商户账号ID 来自用户表UserInfo中的mid
	@Column(length=200)
	private String mid;
	
	//角色表Role 主键ID
	@Column(length=20)
	private Long rid;
	
	//菜单功能表ID
	@Column(length=20)
	private Long mfunctionid;
	
	//功能Url
	@Column(length=200)
	private String url;
	
	@Column(columnDefinition = "int default 0")
	private int is_delete;

	
	
	public Long getMfunctionid() {
		return mfunctionid;
	}

	public void setMfunctionid(Long mfunctionid) {
		this.mfunctionid = mfunctionid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int isDelete) {
		is_delete = isDelete;
	}
	
	

}
