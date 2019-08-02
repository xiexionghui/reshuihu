package org.framework.business.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framework.business.model.dao.base.IBaseDao;
import org.framework.business.model.entity.Menu;
import org.framework.business.model.service.IMenuService;
import org.framework.business.util.PageList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements IMenuService {
	
	@Resource(name = "menuDao")
	private IBaseDao<Menu> menuDao;
		
	@Override
	public Menu getById(Long id) {
		// TODO Auto-generated method stub
		return menuDao.getById(id);
	}

	@Override
	public List<Menu> query(String querySql, Map<Object, Object> params,
			int begin, int max) {
		// TODO Auto-generated method stub
		return menuDao.query(querySql, params, begin, max);
	}

	@Override
	public PageList<Menu> queryMenuPage(String conditionSql,
			Map<Object, Object> params, int begin, int max, int currentPage) {
		// TODO Auto-generated method stub
		return menuDao.queryObjectPage(conditionSql, params, begin, max, currentPage);
	}

	@Override
	public void save(Menu objMenu) {
		// TODO Auto-generated method stub
		menuDao.save(objMenu);
	}

	@Override
	public void update(Menu objMenu) {
		// TODO Auto-generated method stub
		menuDao.update(objMenu);
	}

	@Override
	public Menu queryByName(String mname) {
		Map<Object,Object> map = new HashMap<Object, Object>();
		map.put("mname", mname);
		List<Menu> meList = menuDao.query("select obj from Menu obj where obj.mname =:mname and obj.is_delete =0 ", map, -1, -1);
		if(meList != null && meList.size()>0){
			return meList.get(0);
		}else{
			return null;
		}

	}

}
