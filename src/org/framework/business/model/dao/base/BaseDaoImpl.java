package org.framework.business.model.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import org.framework.business.util.PageList;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;

public class BaseDaoImpl<T> implements IBaseDao<T> {

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = ((Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public BaseDaoImpl(Class<T> type) {
		this.entityClass = type;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T getById(Serializable id) {
		return em.find(entityClass, id);
	}

	public void save(T entity) {
		try {
			em.persist(entity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void batchInsert(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			em.persist(list.get(i));
			if (i % 30 == 0) {
				em.flush();
				em.clear();
			}
		}
	}

	public void batchUpdate(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			em.merge(list.get(i));
			if (i % 30 == 0) {
				em.flush();
				em.clear();
			}
		}
	}

	
	public int batchUpdate(String jpql, Object[] params) {
		// TODO Auto-generated method stub
		Query query = em.createQuery(jpql);
		int parameterIndex = 1;
		if ((params != null) && (params.length > 0)) {
			for (Object obj : params) {
				query.setParameter(parameterIndex++, obj);
			}
		}
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		return Integer.valueOf(query.executeUpdate());
	}

	public void clear() {
		// TODO Auto-generated method stub
		em.clear();
	}

	@SuppressWarnings( { "unchecked" })
	public List<T> executeNamedQuery(String queryName, Object[] params,
			int begin, int max) {
		// TODO Auto-generated method stub
		Query query = em.createNamedQuery(queryName);
		int parameterIndex = 1;
		if ((params != null) && (params.length > 0)) {
			for (Object obj : params) {
				query.setParameter(parameterIndex++, obj);
			}
		}
		if ((begin >= 0) && (max > 0)) {
			query.setFirstResult(begin);
			query.setMaxResults(max);
		}
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		List<T> ret = query.getResultList();
		if ((ret != null) && (ret.size() >= 0)) {
			return ret;
		}
		return new ArrayList<T>();
	}

	@SuppressWarnings( { "unchecked" })
	public List<T> executeNativeNamedQuery(String nnq) {
		// TODO Auto-generated method stub
		return em.createNativeQuery(nnq).getResultList();
	}

	@SuppressWarnings( { "unchecked" })
	public List<T> executeNativeQuery(String nnq, Object[] params, int begin,
			int max) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery(nnq);
		int parameterIndex = 1;
		if ((params != null) && (params.length > 0)) {
			for (Object obj : params) {
				query.setParameter(parameterIndex++, obj);
			}
		}
		if ((begin >= 0) && (max > 0)) {
			query.setFirstResult(begin);
			query.setMaxResults(max);
		}
		List<T> ret = query.getResultList();
		if ((ret != null) && (ret.size() >= 0)) {
			return ret;
		}
		return new ArrayList<T>();
	}

	public int executeNativeSQL(String nnq) {
		// TODO Auto-generated method stub
		Query query = em.createNativeQuery(nnq);
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		return Integer.valueOf(query.executeUpdate());
	}

	@SuppressWarnings( { "unchecked" })
	public List<T> find(String condition, Map<Object, Object> params,
			int begin, int max) {
		// TODO Auto-generated method stub
		String clazzName = entityClass.getName();
		StringBuffer sb = new StringBuffer("select obj from ");
		sb.append(clazzName).append(" obj").append(" where ").append(condition);
		try {
			Query query = em.createQuery(sb.toString());
			for (Object key : params.keySet()) {
				query.setParameter(key.toString(), params.get(key));
			}
			if ((begin >= 0) && (max > 0)) {
				query.setFirstResult(begin);
				query.setMaxResults(max);
			}
			query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
			List<T> ret = query.getResultList();
			if ((ret != null) && (ret.size() >= 0)) {
				return ret;
			}
			return new ArrayList<T>();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		em.flush();
	}

	@SuppressWarnings( { "unchecked" })
	public T getBy(String propertyName, Object value) {
		// TODO Auto-generated method stub
		String clazzName = entityClass.getName();
		StringBuffer sb = new StringBuffer("select obj from ");
		sb.append(clazzName).append(" obj");
		Query query = null;
		if ((propertyName != null) && (value != null)) {
			sb.append(" where obj.").append(propertyName).append(" = :value");
			query = em.createQuery(sb.toString()).setParameter("value", value);
		} else {
			query = em.createQuery(sb.toString());
		}
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		List<T> ret = query.getResultList();
		if ((ret != null) && (ret.size() == 1)) {
			return ret.get(0);
		}
		if ((ret != null) && (ret.size() > 1)) {
			throw new IllegalStateException(
					"worning  --more than one object find!!");
		}
		return null;
	}

	public void lock(T entity, LockModeType lockModeType) {
		// TODO Auto-generated method stub
		if (entity != null && lockModeType != null) {
			em.lock(entity, lockModeType);
		}
	}

	@SuppressWarnings( { "unchecked" })
	public List<T> query(String condition, Map<Object, Object> params,
			int begin, int max) {
		// TODO Auto-generated method stub
		Query query = em.createQuery(condition);
		if ((params != null) && (params.size() > 0)) {
			for (Object key : params.keySet()) {
				query.setParameter(key.toString(), params.get(key));
			}
		}
		if ((begin >= 0) && (max > 0)) {
			query.setFirstResult(begin);
			query.setMaxResults(max);
		}
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		List<T> list = query.getResultList();
		if ((list != null) && (list.size() > 0)) {
			return list;
		}
		return new ArrayList<T>();
	}

	public void remove(Serializable id) {
		// TODO Auto-generated method stub
		Object object = get(entityClass, id);
		if (object != null) {
			try {
				em.remove(object);
			} catch (Exception e) {
				throw new IllegalStateException("remove error");
			}
		}
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		em.merge(entity);
	}

	public Object get(Class<T> clazz, Serializable id) {
		if (id == null) {
			return null;
		}
		return em.find(clazz, id);
	}

	public PageList<T> queryObjectPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage) {
		PageList<T> page = new PageList<T>();
		String objClass[] = entityClass.getName().split("\\.");
		String clazzName = objClass[objClass.length - 1];
		int count = 0;
		List<?> ret = executeNativeNamedQuery("select count(0),count(id) from t_"
				+ clazzName.toLowerCase() + " where 1=1" + conditionSql + " ");
		if ((ret != null) && (ret.size() > 0)) {
			Object obj[] = (Object[]) ret.get(0);
			count = Integer.parseInt(obj[0].toString());
		}
		page.setRowCount(count);
		page.setResult(query("select obj from " + entityClass.getName()
				+ " obj where 1=1 " + conditionSql + " order by id desc",
				params, begin, max));

		if (count % page.getPageSize() == 0) {
			page.setPages(count / page.getPageSize());
		} else {
			page.setPages((count / page.getPageSize()) + 1);
		}
		page.setCurrentPage(currentPage);
		return page;
	}

	public PageList<T> queryObjectPage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage,String orderColumn, int pageSize) {
		PageList<T> page = new PageList<T>();
		if (pageSize != 0) {
			page.setPageSize(pageSize);
		}
		String objClass[] = entityClass.getName().split("\\.");
		String clazzName = objClass[objClass.length - 1];
		int count = 0;
		List<?> ret = executeNativeNamedQuery("select count(0) as qty,count(1) as num from t_"
				+ clazzName.toLowerCase()
				+ " obj where 1=1 "
				+ conditionSql
				+ "");
		if ((ret != null) && (ret.size() > 0)) {
			Object obj[] = (Object[]) ret.get(0);
			count = Integer.parseInt(obj[0].toString());
		}
		page.setRowCount(count);
		page.setResult(query("select obj from " + entityClass.getName()
				+ " obj where 1=1 " + conditionSql + " " + orderColumn, params,
				begin, max));

		if (count % page.getPageSize() == 0) {
			page.setPages(count / page.getPageSize());
		} else {
			page.setPages((count / page.getPageSize()) + 1);
		}
		page.setCurrentPage(currentPage);
		return page;
	}

	
	public PageList<T> queryObject5Page(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage) {
		PageList<T> page = new PageList<T>();
		page.setPageSize(5);
		String objClass[] = entityClass.getName().split("\\.");
		String clazzName = objClass[objClass.length - 1];
		int count = 0;
		List<?> ret = executeNativeNamedQuery("select count(0),count(id) from t_"
				+ clazzName.toLowerCase() + " where 1=1" + conditionSql + " ");
		if ((ret != null) && (ret.size() > 0)) {
			Object obj[] = (Object[]) ret.get(0);
			count = Integer.parseInt(obj[0].toString());
		}
		page.setRowCount(count);
		page.setResult(query("select obj from " + entityClass.getName()
				+ " obj where 1=1 " + conditionSql + " order by id desc",
				params, begin, max));

		if (count % page.getPageSize() == 0) {
			page.setPages(count / page.getPageSize());
		} else {
			page.setPages((count / page.getPageSize()) + 1);
		}
		page.setCurrentPage(currentPage);
		return page;
	}
	
}