package org.framework.business.model.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framework.business.model.dao.base.IBaseDao;
import org.framework.business.model.entity.Member;
import org.framework.business.model.service.IMemberService;
import org.framework.business.util.PageList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("menberService")
@Transactional
public class MemberServiceImpl implements IMemberService {
	@Resource(name = "memberDao")
	private IBaseDao<Member> memberDao;

	public List<Member> query(String querySql, Map<Object, Object> params,
			int begin, int max) {
		return memberDao.query(querySql, params, begin, max);
	}

	public PageList<Member> queryMenuPage(String conditionSql,
			Map<Object, Object> params, int begin, int max, int currentPage) {
		return memberDao.queryObjectPage(conditionSql, params, begin, max,
				currentPage);
	}

}
