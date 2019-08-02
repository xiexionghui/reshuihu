package org.framework.business.model.service;

import java.util.List;
import java.util.Map;

import org.framework.business.model.entity.Mfunction;

public interface IMFunctionService {
	
	public void save(Mfunction mfunction);
    
    /**
     * 根据主键获取对象
     * @param <T>
     * @param clazz 实体类
     * @param id    主键
     * @return
     */
    public Mfunction getById(Long id);
    
    
	/**
	 * 查询所有
	 */
	public List<Mfunction> query(String querySql,Map<Object, Object> params,int begin, int max);
	
	
    public void update(Mfunction mfunction);
	

}