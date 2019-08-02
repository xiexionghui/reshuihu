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
public class CompanyManagerController extends MyFrameworkInterceptor {
	@Autowired
	private IUserServices userService;

	@Autowired
	private ICompanyService companyService;

	/**
	 * 查询厂商列表
	 */
	@RequestMapping(value = "/queryCompanyList.htm")
	public String queryCompanyList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String page,
			String departName, String name, String mobile) throws IOException {

		User user = getUserSession(request);

		StringBuffer objStr = new StringBuffer();
		if (name != null && !name.equals("")) {
			objStr.append(" and name like '%" + name + "%' ");
		}
		if (mobile != null && !mobile.equals("")) {
			objStr.append(" and mobile like '%" + mobile + "%'");
			
		}
		objStr.append(" and is_delete=0");
		
		
		

		PageList<Company> pageList = new PageList<Company>();
		if (page == null || page.equals("")) {
			page = "1";
		}

		pageList = companyService.queryMenuPage(objStr.toString(), null,
				(Integer.parseInt(page) - 1) * pageList.getPageSize(), pageList
						.getPageSize(), Integer.parseInt(page));

		PageUtil.savePageModelMap("", "", "", pageList, modelMap);
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("mobile", mobile);

		return "/user/company_list";
	}

	/**
	 * 厂商修改界面
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/no/toUpdateCompany.htm")
	public String toUpdateCompany(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id)
			throws IOException {
		User user = getUserSession(request);

		if (id != null && !id.equals("")) {
			Company company = companyService.getById(Long.parseLong(id));
			modelMap.addAttribute("obj", company);
			List<Company> list = companyService.query(
					"select obj from Company obj where obj.is_delete = 0",
					null, -1, -1);
			modelMap.addAttribute("list", list);

			return "/user/update_company";
		} else {
			ResponseAlertUtil.AlertMsg(response, "操作失败", true, "");
			return null;
		}

	}

	/**
	 * 更新厂商信息
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param company
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateCompany.htm")
	public void updateCompany(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, Company company)
			throws IOException {

		User user = getUserSession(request);

		Map<String, Object> map = new HashMap<String, Object>();
		if (company.getId() != null && !company.getId().equals("")) {
			company.setAddTime(new Date());
			companyService.update(company);
			map.put("flag", "0");
		}

		else {
			map.put("flag", "1");
			map.put("errMsg", "更新失败");
		}
		response.getWriter().print(JsonUtil.parseJSON(map));
	}

	/**
	 * 厂商删除
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param id
	 * @throws IOException
	 */
	@RequestMapping(value = "/delCompany.htm")
	public void delCompany(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id)
			throws IOException {
		User user = getUserSession(request);

		Company company = companyService.getById(Long.parseLong(id));
		company.setIs_delete(1);
		companyService.update(company);

	}

	/**
	 * 添加厂商信息页面
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/no/toAddCompany.htm")
	public String toAddCompany(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws IOException {
		User user = getUserSession(request);
		List<Company> list = companyService.query(
				"select obj from Company obj where obj.is_delete = 0", null,
				-1, -1);
		modelMap.addAttribute("list", list);

		return "/user/add_company";
	}

	@RequestMapping(value = "/saveCompany.htm")
	public void saveCompany(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String name,
			String phone, String email, String contact_name, String mobile,
			String address) throws IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		if (name != null && !name.equals("")) {
			Company company = new Company();
			company.setName(name);
			company.setAddress(address);
			company.setAddTime(new Date());
			String uuid = UUID.randomUUID().toString();
			company.setC_no(uuid);
			company.setContact_name(contact_name);
			company.setEmail(email);
			company.setIs_delete(0);
			company.setMobile(mobile);
			company.setPhone(phone);

			companyService.save(company);
			map.put("flag", "0");
		} else {
			map.put("flag", "1");
			map.put("errMsg", "添加失败");
		}
		response.getWriter().print(JsonUtil.parseJSON(map));
	}

}
