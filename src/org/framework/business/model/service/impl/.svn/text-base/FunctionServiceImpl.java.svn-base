package org.framework.business.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framework.business.model.dao.base.IBaseDao;
import org.framework.business.model.entity.Function;
import org.framework.business.model.service.IFunctionService;
import org.framework.business.util.PageList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("functionService")
@Transactional
public class FunctionServiceImpl implements IFunctionService {

	@Resource(name = "functionDao")
	private IBaseDao<Function> functionDao;
	
	@Override
	public Function getById(Long id) {
		// TODO Auto-generated method stub
		return functionDao.getById(id);
	}

	@Override
	public List<Function> query(String querySql, Map<Object, Object> params,
			int begin, int max) {
		// TODO Auto-generated method stub
		return functionDao.query(querySql, params, begin, max);
	}

	@Override
	public PageList<Function> queryFunctionPage(String conditionSql,
			Map<Object, Object> params, int begin, int max, int currentPage) {
		// TODO Auto-generated method stub
		return functionDao.queryObjectPage(conditionSql, params, begin, max, currentPage);
	}

	@Override
	public void save(Function objFunction) {
		// TODO Auto-generated method stub
		functionDao.save(objFunction);
	}

	@Override
	public void update(Function objFunction) {
		// TODO Auto-generated method stub
		functionDao.update(objFunction);
	}
	
	 public Function getByName(String name){
		 List<Function> list = functionDao.query(" select obj from Function obj where obj.fname ='"+name+"'", new HashMap<Object, Object>(),-1,-1);
		 
		 if(null!=list && list.size()>0){
			 return list.get(0);
		 }else{
			 return null;
		 }
		 
	 }

}
