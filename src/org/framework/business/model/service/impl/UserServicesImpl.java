package org.framework.business.model.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framework.business.model.dao.base.IBaseDao;
import org.framework.business.model.entity.OperLog;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.IUserServices;
import org.framework.business.util.PageList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("userService")
@Transactional
public class UserServicesImpl implements IUserServices {

	@Resource(name = "userDao")
	private IBaseDao<User> userDao;
	
	@Resource(name = "operLogDao")
	private IBaseDao<OperLog> operLogDao;
	
	
	public User getById(Long id) {
		return userDao.getById(id);
	}
	
	public void save(User userInfo) {
    	userDao.save(userInfo);
	}
	
	public void remove(Long id) {
    	userDao.remove(id);
	}

	
	public void saveOperLog(OperLog entity) {
    	operLogDao.save(entity);
	}
	
	public PageList<OperLog> queryOperLogPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage) {
		return operLogDao.queryObjectPage(conditionSql, params, begin, max, currentPage);
	}
	
	
	
	public void update(User userInfo) {
		userDao.update(userInfo);
	}
	
	public PageList<User> queryUserPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage) {
		return userDao.queryObjectPage(conditionSql, params, begin, max, currentPage);
	}
	
	
	public List<User> queryUser(String sql,Map<Object, Object> params,int begin,int max){
		return userDao.query(sql, params, begin, max);
	}
	
	/**
	 * 根据列名获取对象
	 */
	public User getBy(String propertyName, String value){
		return userDao.getBy(propertyName, value);
	}
	
	
	public int querySumUserCount(){
		int count = 0;
		List<?> list = userDao.executeNativeNamedQuery("select count(0),count(1) from t_user where is_back = 0");
		if(list!=null && list.size()>0){
			Object[] obj = (Object[])list.get(0);
			if(obj[0]!=null && !obj[0].toString().equals("")){
			count = Integer.parseInt(obj[0].toString());
			}
		}
		return count;
	}
	
	

}
