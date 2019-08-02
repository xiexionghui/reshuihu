package org.framework.business.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_role")
public class Role  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838732995856086555L;
	@Id
    @GeneratedValue
    private Long id;
	
	//角色名称
	@Column(length=100)
	private String rname;
	
	//商户号  -- 来自用户表mid或者parent_mid字段
	@Column(length=100)
	private String mid;
	@Column(columnDefinition = "int default 0")
	private int role_type;
	
	//备注
	@Column(length=500)
	private String reamrk;
	
	@Column(columnDefinition = "int default 0")
	private int is_delete;
	
	private Date addTime;
	
	

	public int getRole_type() {
		return role_type;
	}

	public void setRole_type(int role_type) {
		this.role_type = role_type;
	}

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

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getReamrk() {
		return reamrk;
	}

	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int isDelete) {
		is_delete = isDelete;
	}
	
	
	
}
