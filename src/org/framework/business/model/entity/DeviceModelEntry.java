package org.framework.business.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//设备模式操作表 
@Entity
@Table(name="t_devicemodelentry")
public class DeviceModelEntry  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1788573265467304551L;
	@Id
    @GeneratedValue
	private Long id;
	
	private String d_val;//温度
	
	private String shichang;//持续时长
	
	private int d_sequene;//排序 1 2 3 4
	
	private Long modelId;//模式ID
	
	private String modelName;//模式名称
	
	private Long typeId;//分类ID 
	
	private String typeName;//分类名称

	public String getD_val() {
		return d_val;
	}

	public void setD_val(String d_val) {
		this.d_val = d_val;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public int getD_sequene() {
		return d_sequene;
	}

	public void setD_sequene(int d_sequene) {
		this.d_sequene = d_sequene;
	}

	public String getShichang() {
		return shichang;
	}

	public void setShichang(String shichang) {
		this.shichang = shichang;
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
