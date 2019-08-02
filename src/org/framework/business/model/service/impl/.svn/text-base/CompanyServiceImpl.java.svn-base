package org.framework.business.model.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framework.business.model.dao.base.IBaseDao;
import org.framework.business.model.entity.Company;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.ICompanyService;
import org.framework.business.util.PageList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements ICompanyService {
	@Resource(name = "companyDao")
	private IBaseDao<Company> companyDao;
	
	public Company getById(Long id) {
		// TODO Auto-generated method stub
		return companyDao.getById(id);
	}

	public List<Company> query(String querySql, Map<Object, Object> params,
			int begin, int max) {
		// TODO Auto-generated method stub
		return companyDao.query(querySql, params, begin, max);
	}

	public PageList<Company> queryMenuPage(String conditionSql,
			Map<Object, Object> params, int begin, int max, int currentPage) {
		// TODO Auto-generated method stub
		return companyDao.queryObjectPage(conditionSql, params, begin, max, currentPage);
	}

	public void save(Company entity) {
		// TODO Auto-generated method stub
		companyDao.save(entity);
	}

	public void update(Company entity) {
		// TODO Auto-generated method stub
		companyDao.update(entity);
	}
	
	public void remove(Long id){
		companyDao.remove(id);
	}
	

}
