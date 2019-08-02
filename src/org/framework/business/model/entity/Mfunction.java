package org.framework.business.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_mfunction")
public class Mfunction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838732995856086555L;
	@Id
    @GeneratedValue
    private Long id;
	
	//菜单表 Menu 主键ID
	@Column(length=20)
	private Long menuid;
	
	//功能表 Function 主键ID
	@Column(length=20)
	private Long functionid;
	
	//功能名称
	@Column(length=200)
	private String functionname;
	
	//功能链接地址  
	@Column(length=200)
	private String functionurl;
	
	//备注
	@Column(length=500)
	private String reamrk;
	
	@Column(columnDefinition = "int default 0")
	private int is_delete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public String getFunctionname() {
		return functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public Long getFunctionid() {
		return functionid;
	}

	public void setFunctionid(Long functionid) {
		this.functionid = functionid;
	}

	public String getFunctionurl() {
		return functionurl;
	}

	public void setFunctionurl(String functionurl) {
		this.functionurl = functionurl;
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
