package org.framework.business.model.dao;

import org.framework.business.model.dao.base.BaseDaoImpl;
import org.framework.business.model.entity.Company;
import org.framework.business.model.entity.Member;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao extends BaseDaoImpl<Member>  {

}
