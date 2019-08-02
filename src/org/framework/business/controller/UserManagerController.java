package org.framework.business.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.business.model.entity.Company;
import org.framework.business.model.entity.OperLog;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.ICompanyService;
import org.framework.business.model.service.IRoleService;
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

@Controller
@RequestMapping(value = "/admin")
public class UserManagerController extends MyFrameworkInterceptor {
	@Autowired
	private IUserServices userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private ICompanyService companyService;

	// 日志列表 /queryOperLogList.htm
	@RequestMapping(value = "/no/queryOperLogList.htm")
	public String queryOperLogList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String page,
			String one_menu, String two_menu, String username, String content) {

		StringBuffer objStr = new StringBuffer();

		if (one_menu != null && !one_menu.equals("")) {
			objStr.append(" and one_menu like '%" + one_menu + "%' ");
		}
		if (two_menu != null && !two_menu.equals("")) {
			objStr.append(" and two_menu like '%" + two_menu + "%' ");
		}
		if (username != null && !username.equals("")) {
			objStr.append(" and (userName like '%" + username
					+ "%' or nickName like '%" + username + "%') ");
		}
		if (content != null && !content.equals("")) {
			objStr.append(" and content like '%" + content + "%' ");
		}

		PageList<OperLog> pageList = new PageList<OperLog>();
		if (page == null || page.equals("")) {
			page = "1";
		}

		pageList = userService.queryOperLogPage(objStr.toString(), null,
				(Integer.parseInt(page) - 1) * pageList.getPageSize(), pageList
						.getPageSize(), Integer.parseInt(page));
		PageUtil.savePageModelMap("", "", "", pageList, modelMap);

		return "/user/log_list";
	}

	/**
	 * 查询用户
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/queryUserList.htm")
	public String queryUserList(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String page,
			String departName, String name, String mobile) throws IOException {
		User user = getUserSession(request);
		saveOperLog(user, MenuName.XTGL, MenuName.XTGL_GLY, "查询用户", userService);
		StringBuffer objStr = new StringBuffer();
		if (name != null && !name.equals("")) {
			objStr.append(" and (userName like '%" + name
					+ "%' or nickName like '%" + name + "%')");
		}

		if (mobile != null && !mobile.equals("")) {
			objStr.append(" and mobile like '%" + mobile + "%'");
		}

		PageList<User> pageList = new PageList<User>();
		if (page == null || page.equals("")) {
			page = "1";
		}
		objStr.append(" and userName != 'admin' and is_delete = 0");
		pageList = userService.queryUserPage(objStr.toString(), null, (Integer
				.parseInt(page) - 1)
				* pageList.getPageSize(), pageList.getPageSize(), Integer
				.parseInt(page));
		PageUtil.savePageModelMap("", "", "", pageList, modelMap);
		modelMap.addAttribute("name", name);
		modelMap.addAttribute("mobile", mobile);
		return "/user/user_list";
	}

	@RequestMapping(value = "/no/toAddUser.htm")
	public String toAddUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws IOException {
		User user = getUserSession(request);
		List<Company> list = companyService.query(
				"select obj from Company obj where obj.is_delete = 0", null,
				-1, -1);
		modelMap.addAttribute("list", list);
		return "/user/add_user";
	}

	@RequestMapping(value = "/no/toUpdateUser.htm")
	public String toUpdateUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id)
			throws IOException {
		User loginUser = getUserSession(request);

		if (id != null && !id.equals("")) {
			User user = userService.getById(Long.parseLong(id));
			modelMap.addAttribute("obj", user);
			List<Company> list = companyService.query(
					"select obj from Company obj where obj.is_delete = 0",
					null, -1, -1);
			modelMap.addAttribute("list", list);

			return "/user/update_user";
		} else {
			ResponseAlertUtil.AlertMsg(response, "操作失败", true, "");
			return null;
		}

	}

	@RequestMapping(value = "/updateUser.htm")
	public void updateUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id,
			String companyId, String admin_type, String userName,
			String password, String nickName, String mobile, String email)
			throws IOException {
		User users = getUserSession(request);
		saveOperLog(users, MenuName.XTGL, MenuName.XTGL_GLY, "更新用户",
				userService);

		User user = userService.getById(Long.parseLong(id));

		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			user.setMobile(mobile);
			user.setNickName(nickName);
			if (password != null && !password.equals("")
					&& !password.equals("null")) {
				user.setPassword(Md5Encrypt.md5(password));
			}
			user.setEmail(email);
			user.setStatus(0l);
			user.setRid("");
			user.setAdmin_type(Integer.parseInt(admin_type));
			if (companyId != null && !companyId.equals("")
					&& !companyId.equals("null") && user.getAdmin_type() == 1) {
				Company company = companyService.getById(Long
						.parseLong(companyId));
				user.setCompanyId(company.getId());
				user.setCompanyName(company.getName());
				user.setCompanyNo(company.getC_no());
			}
			userService.update(user);
			map.put("flag", "0");
		} else {
			map.put("flag", "1");
			map.put("errMsg", "用户不存在");
		}
		response.getWriter().print(JsonUtil.parseJSON(map));
	}

	@RequestMapping(value = "/saveUser.htm")
	public void saveUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String password,
			String admin_type, String companyId, String userName,
			String mobile, String nickName) throws IOException {
		User users = getUserSession(request);
		saveOperLog(users, MenuName.XTGL, MenuName.XTGL_GLY, "保存用户",
				userService);

		if (admin_type == null || admin_type.equals("")) {
			admin_type = "0";
		}

		User user = userService.getBy("userName", userName);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user == null) {
			user = new User();
			user.setUserName(userName);
			user.setIs_delete(0);
			user.setIs_admin(0);
			user.setMobile(mobile);
			user.setNickName(nickName);
			user.setPassword(Md5Encrypt.md5(password));
			user.setStatus(0l);
			user.setAddTime(new Date());
			user.setRid("");
			user.setAdmin_type(Integer.parseInt(admin_type));
			if (companyId != null && !companyId.equals("")
					&& !companyId.equals("null") && user.getAdmin_type() == 1) {
				Company company = companyService.getById(Long
						.parseLong(companyId));
				user.setCompanyId(company.getId());
				user.setCompanyName(company.getName());
				user.setCompanyNo(company.getC_no());
			}

			userService.save(user);
			map.put("flag", "0");
		} else {
			map.put("flag", "1");
			map.put("errMsg", "用户名已存在");
		}
		response.getWriter().print(JsonUtil.parseJSON(map));
	}

	@RequestMapping(value = "/delUser.htm")
	public void delUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id)
			throws IOException {
		User users = getUserSession(request);
		saveOperLog(users, MenuName.XTGL, MenuName.XTGL_GLY, "删除用户",
				userService);

		User user = userService.getById(Long.parseLong(id));
		user.setIs_delete(1);
		userService.update(user);

		userService.remove(Long.parseLong(id));

	}

	// 禁用
	@RequestMapping(value = "/canUser.htm")
	public void canUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id)
			throws IOException {
		User users = getUserSession(request);
		saveOperLog(users, MenuName.XTGL, MenuName.XTGL_GLY, "禁用用户",
				userService);

		User user = userService.getById(Long.parseLong(id));
		user.setStatus(1l);
		userService.update(user);

	}

	// 启用
	@RequestMapping(value = "/qyUser.htm")
	public void qyUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap, String id)
			throws IOException {
		User users = getUserSession(request);
		saveOperLog(users, MenuName.XTGL, MenuName.XTGL_GLY, "启用用户",
				userService);

		User user = userService.getById(Long.parseLong(id));
		user.setStatus(0l);
		user.setIs_delete(0);
		userService.update(user);

	}

}
