package org.framework.business.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.business.model.entity.Company;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.ICompanyService;
import org.framework.business.model.service.IMemberService;
import org.framework.business.model.service.IUserServices;
import org.framework.business.util.JsonUtil;
import org.framework.business.util.Md5Encrypt;
import org.framework.business.util.MenuName;
import org.framework.business.util.PageList;
import org.framework.business.util.PageUtil;
import org.framework.business.util.ResponseAlertUtil;
import org.framework.xcode.spring.interceptor.MyFrameworkInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

//厂商
@Controller
@RequestMapping(value = "/admin")
public class MemberManagerController extends MyFrameworkInterceptor {

	@Autowired
	private IMemberService memberService;

	

}
