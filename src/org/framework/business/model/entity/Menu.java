package org.framework.business.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_menu")
public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838732995856086555L;
	@Id
    @GeneratedValue
    private Long id;
	
	//菜单名称
	@Column(length=200)
	private String mname;
	
	//菜单链接url
	@Column(length=200)
	private String url;
	
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

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
