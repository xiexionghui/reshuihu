package org.framework.business.model.service;

import java.util.List;
import java.util.Map;

import org.framework.business.model.entity.Function;
import org.framework.business.util.PageList;

public interface IFunctionService {
	public void save(Function objFunction);
    
    /**
     * 根据主键获取对象
     * @param <T>
     * @param clazz 实体类
     * @param id    主键
     * @return
     */
    public Function getById(Long id);
    
    /***
     * 根据名称查询
     * @param name
     * @return
     */
    public Function getByName(String name);
    
	/**
	 * 查询所有
	 */
	public List<Function> query(String querySql,Map<Object, Object> params,int begin, int max);
	
	
    public void update(Function objFunction);
	
    
	public PageList<Function> queryFunctionPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage); 
}
