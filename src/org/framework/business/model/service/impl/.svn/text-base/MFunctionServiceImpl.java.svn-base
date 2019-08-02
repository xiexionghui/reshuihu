package org.framework.business.model.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framework.business.model.dao.base.IBaseDao;
import org.framework.business.model.entity.Mfunction;
import org.framework.business.model.service.IMFunctionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mfunctionService")
@Transactional
public class MFunctionServiceImpl implements IMFunctionService {
	
	@Resource(name = "mfunctionDao")
	private IBaseDao<Mfunction> mfunctionDao;
	
	@Override
	public Mfunction getById(Long id) {
		// TODO Auto-generated method stub
		return mfunctionDao.getById(id);
	}

	@Override
	public List<Mfunction> query(String querySql, Map<Object, Object> params,
			int begin, int max) {
		// TODO Auto-generated method stub
		return mfunctionDao.query(querySql, params, begin, max);
	}

	@Override
	public void save(Mfunction mfunction) {
		// TODO Auto-generated method stub
		mfunctionDao.save(mfunction);
	}

	@Override
	public void update(Mfunction mfunction) {
		// TODO Auto-generated method stub
		mfunctionDao.update(mfunction);
	}

}
