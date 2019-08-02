package org.framework.business.model.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framework.business.model.dao.base.IBaseDao;
import org.framework.business.model.entity.RoleQx;
import org.framework.business.model.service.IRoleQxService;
import org.framework.business.util.PageList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleQxService")
@Transactional
public class RoleQxServiceImpl implements IRoleQxService {
	@Resource(name = "roleQxDao")
	private IBaseDao<RoleQx> roleQxDao;
	
	@Override
	public RoleQx getById(Long id) {
		// TODO Auto-generated method stub
		return roleQxDao.getById(id);
	}

	@Override
	public List<RoleQx> query(String querySql, Map<Object, Object> params,
			int begin, int max) {
		return roleQxDao.query(querySql, params, begin, max);
	}

	@Override
	public PageList<RoleQx> queryUserPage(String conditionSql,
			Map<Object, Object> params, int begin, int max, int currentPage) {
		// TODO Auto-generated method stub
		return roleQxDao.queryObjectPage(conditionSql, params, begin, max, currentPage);
	}

	@Override
	public void save(RoleQx objRoleQx) {
		// TODO Auto-generated method stub
		roleQxDao.save(objRoleQx);
	}

	@Override
	public void update(RoleQx objRoleQx) {
		// TODO Auto-generated method stub
		roleQxDao.update(objRoleQx);
	}
	
	public void deleteRoleQx(Long id){
		roleQxDao.remove(id);
	}
}
