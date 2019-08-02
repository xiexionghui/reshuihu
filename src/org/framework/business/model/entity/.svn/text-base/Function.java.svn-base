package org.framework.business.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_function")
public class Function implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838732995856086555L;
	@Id
    @GeneratedValue
    private Long id;
	//功能名称
	@Column(length=200)
	private String fname;
	
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
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
