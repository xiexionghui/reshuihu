package org.framework.business.model.service;

import java.util.List;
import java.util.Map;

import org.framework.business.model.entity.Company;
import org.framework.business.util.PageList;

public interface ICompanyService {
	public void save(Company entity);
    
    
    public Company getById(Long id);
    

	public List<Company> query(String querySql,Map<Object, Object> params,int begin, int max);
	
	
    public void update(Company entity);
	
    
	public PageList<Company> queryMenuPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage);
	
	public void remove(Long id);
	
}
