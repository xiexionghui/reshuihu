package org.framework.business.model.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framework.business.model.dao.base.IBaseDao;
import org.framework.business.model.entity.Role;
import org.framework.business.model.service.IRoleService;
import org.framework.business.util.PageList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Resource(name = "roleDao")
	private IBaseDao<Role> roleDao;
	
	
	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return roleDao.getById(id);
	}

	@Override
	public List<Role> query(String querySql, Map<Object, Object> params,
			int begin, int max) {
		return roleDao.query(querySql, params, begin, max);
	}

	@Override
	public PageList<Role> queryRolePage(String conditionSql,Map<Object, Object> params, int begin, int max, int currentPage) {
		// TODO Auto-generated method stub
		return roleDao.queryObjectPage(conditionSql, params, begin, max, currentPage);
	}

	@Override
	public void save(Role objRole) {
		// TODO Auto-generated method stub
		roleDao.save(objRole);
	}

	@Override
	public void update(Role objRoleQx) {
		// TODO Auto-generated method stub
		roleDao.update(objRoleQx);
	}

}
