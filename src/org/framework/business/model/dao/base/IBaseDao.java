package org.framework.business.model.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.LockModeType;
import org.framework.business.util.PageList;
/**
 * @author zhuth @2014/11
 */
public interface IBaseDao<T> {	
	/**
     * 持久化实体
     * @param entity
     */
    void save(T entity);
    
    /**
     * 根据主键查询实体
     * @param <T>
     * @param clazz  实体类
     * @param id     主键
     * @return
     */
	
    T getById(Serializable id);
    

	abstract void remove(Serializable id);

	
	void update(T entity);
	
	T getBy(String propertyName, Object value);

	List<T> executeNamedQuery(String queryName, Object[] params, int begin, int max);
	
	List<T> find(String query, Map<Object, Object> params, int begin, int max);
	
	List<T> query(String query, Map<Object, Object> params, int begin, int max);

	int batchUpdate(String jpql, Object[] params);
	
	void batchUpdate(List<T> list);
	
	void batchInsert(List<T> list);

	List<T> executeNativeNamedQuery(String nnq);

	List<T> executeNativeQuery(String nnq, Object[] params, int begin, int max);

	int executeNativeSQL(String nnq);

	void flush();

	void clear();

	void lock(T entity, LockModeType lockModeType);
	//默认排序
	PageList<T> queryObjectPage(String conditionSql,Map<Object, Object> params,int begin, int max, int currentPage);
	//自定义排序
	PageList<T> queryObjectPage(String conditionSql,Map<Object, Object> params,int begin, int max, int currentPage,String orderColumn,int pageSize);
    
	public PageList<T> queryObject5Page(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage);
}
