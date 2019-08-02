package org.framework.business.model.service;

import java.util.List;
import java.util.Map;

import org.framework.business.model.entity.Menu;
import org.framework.business.util.PageList;

public interface IMenuService {
	
	public void save(Menu objMenu);
    
    
    public Menu getById(Long id);
    

	public List<Menu> query(String querySql,Map<Object, Object> params,int begin, int max);
	
	
    public void update(Menu objMenu);
	
    
	public PageList<Menu> queryMenuPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage); 
	
	public Menu queryByName(String mname);
}
