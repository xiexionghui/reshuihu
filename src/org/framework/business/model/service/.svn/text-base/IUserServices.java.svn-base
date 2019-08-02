package org.framework.business.model.service;

import java.util.List;
import java.util.Map;

import org.framework.business.model.entity.OperLog;
import org.framework.business.model.entity.User;
import org.framework.business.util.PageList;

public interface IUserServices {
	
	public User getById(Long id);
	
	public void save(User userInfo);
	
	public void remove(Long id);

	public void update(User userInfo);
	
	public PageList<User> queryUserPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage);
	
	public List<User> queryUser(String sql,Map<Object, Object> params,int begin,int max);
	
	/**
	 * 根据列名获取对象
	 */
	public User getBy(String propertyName, String value);
	
	
	public int querySumUserCount();
	
	
	public void saveOperLog(OperLog entity);
	
	public PageList<OperLog> queryOperLogPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage);
}
