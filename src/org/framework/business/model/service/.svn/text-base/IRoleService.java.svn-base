package org.framework.business.model.service;

import java.util.List;
import java.util.Map;

import org.framework.business.model.entity.Role;
import org.framework.business.util.PageList;

public interface IRoleService {
	    public void save(Role objRole);
	    
	    /**
	     * 根据主键获取对象
	     * @param <T>
	     * @param clazz 实体类
	     * @param id    主键
	     * @return
	     */
	    public Role getById(Long id);
	    
	    
		/**
		 * 查询所有
		 */
		public List<Role> query(String querySql,Map<Object, Object> params,int begin, int max);
		
		
	    public void update(Role objRoleQx);
		
	    
		public PageList<Role> queryRolePage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage); 
}
