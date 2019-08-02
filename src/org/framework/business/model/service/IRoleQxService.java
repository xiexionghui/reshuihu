package org.framework.business.model.service;

import java.util.List;
import java.util.Map;

import org.framework.business.model.entity.RoleQx;
import org.framework.business.util.PageList;

public interface IRoleQxService {
	
	    public void save(RoleQx objRoleQx);
	    
	    /**
	     * 根据主键获取对象
	     * @param <T>
	     * @param clazz 实体类
	     * @param id    主键
	     * @return
	     */
	    public RoleQx getById(Long id);
	    
	    
		/**
		 * 查询所有
		 */
		public List<RoleQx> query(String querySql,Map<Object, Object> params,int begin, int max);
		
		
	    public void update(RoleQx objRoleQx);
		
	    
		public PageList<RoleQx> queryUserPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage); 
		
		public void deleteRoleQx(Long id);
}
