package org.framework.business.model.service;

import java.util.List;
import java.util.Map;

import org.framework.business.model.entity.Company;
import org.framework.business.model.entity.Member;
import org.framework.business.util.PageList;

public interface IMemberService {

	public List<Member> query(String querySql, Map<Object, Object> params,
			int begin, int max);

	public PageList<Member> queryMenuPage(String conditionSql,
			Map<Object, Object> params, int begin, int max, int currentPage);

}
