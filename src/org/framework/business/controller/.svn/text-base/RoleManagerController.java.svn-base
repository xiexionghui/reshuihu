package org.framework.business.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.business.model.entity.Role;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.IRoleService;
import org.framework.business.model.service.IUserServices;
import org.framework.business.util.JsonUtil;
import org.framework.business.util.MenuName;
import org.framework.business.util.PageUtil;
import org.framework.business.util.ResponseAlertUtil;
import org.framework.business.util.StringUtil;
import org.framework.xcode.spring.interceptor.MyFrameworkInterceptor;
import org.framework.business.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class RoleManagerController extends MyFrameworkInterceptor{
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserServices userService;
	
	/**
	 * 分页查角色
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/queryRole.htm")
	public String queryRole(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String page,String name){
		User user = getUserSession(request);
		saveOperLog(user, MenuName.XTGL, MenuName.XTGL_JS, "查询角色", userService);
		
		StringBuffer objStr=new StringBuffer();
		if(name!=null && !name.equals("")){
			objStr.append(" and rname like '%"+name+"%' ");
		}
		
		
		PageList<Role> pageList = new PageList<Role>();
		if(page == null || page.equals("")){
			page="1";	
		}
		
		objStr.append(" and is_delete = 0");
		
		pageList = roleService.queryRolePage(objStr.toString(), null, (Integer.parseInt(page)-1)*pageList.getPageSize(), pageList.getPageSize(), Integer.parseInt(page));
		PageUtil.savePageModelMap("", "", "", pageList, modelMap);
		modelMap.addObject("name", name);
		return "/role/role_list";
	}
	
	/**
	 * 跳转到新增角色页面
	 */
	@RequestMapping(value="/no/addRole.htm")
	public String addRole(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
		return "/role/add_role";
	}
	
	/**
	 * 新增角色
	 * @throws IOException 
	 */
	@RequestMapping(value="/saveRole.htm")
	public void saveRole(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String rname,String id,String role_type) throws IOException{
		User users = getUserSession(request);
		saveOperLog(users, MenuName.XTGL, MenuName.XTGL_JS, "新增角色", userService);
		
		Map<String,Object> map = new HashMap<String, Object>();
		if(id == null || id.equals("")){//新增
			rname = StringUtil.StringFilter(rname);
			List<Role> ro = roleService.query("select obj from Role obj where rname='"+rname+"' and is_delete=0 ", null, -1, -1);
			if(ro!=null && ro.size()>0){
				map.put("flag", "1");
				map.put("errMsg", "角色已存在");
			}else{
				map.put("flag", "0");
				
				Role role = new Role();
				rname = StringUtil.StringFilter(rname);
				role.setRname(rname);
				role.setAddTime(new Date());
				role.setMid("0");
				role.setRole_type(Integer.parseInt(role_type));
				roleService.save(role);
				
				User user = getUserSession(request);
				
				
			}
		}else{//修改
			Role role = roleService.getById(Long.parseLong(id));
			
			User user = getUserSession(request);
			
			
			role.setRname(rname);
			role.setRole_type(Integer.parseInt(role_type));
			roleService.update(role);
			
			
			
			map.put("flag", "0");
		}
		
		response.getWriter().print(JsonUtil.parseJSON(map));
	
	
	}
	
	/**
	 * 删除角色
	 * @throws IOException 
	 */
	@RequestMapping(value="/delRole.htm")
	public void delRole(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String id) throws IOException{
		User user = getUserSession(request);
		saveOperLog(user, MenuName.XTGL, MenuName.XTGL_JS, "删除角色", userService);
		
		Role role = roleService.getById(Long.parseLong(id));
		role.setIs_delete(1);
		roleService.update(role);
	}
	
	/**
	 * 编辑角色
	 * 
	 */
	@RequestMapping(value="/no/toUpdateRole.htm")
	public String toUpdateRole(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String id){
		User user = getUserSession(request);
		saveOperLog(user, MenuName.XTGL, MenuName.XTGL_JS, "编辑角色", userService);
		Role role = roleService.getById(Long.parseLong(id));
		modelMap.addObject("role", role);
		return "/role/update_role";
	}
	
}
