package org.framework.business.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.business.model.entity.Menu;
import org.framework.business.model.entity.Mfunction;
import org.framework.business.model.entity.Role;
import org.framework.business.model.entity.RoleQx;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.IMFunctionService;
import org.framework.business.model.service.IMenuService;
import org.framework.business.model.service.IRoleQxService;
import org.framework.business.model.service.IRoleService;
import org.framework.business.model.service.IUserServices;
import org.framework.business.util.JsonUtil;
import org.framework.business.util.MenuName;
import org.framework.business.util.ResponseAlertUtil;
import org.framework.xcode.spring.interceptor.MyFrameworkInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class RoleQxManagerController extends MyFrameworkInterceptor{
	@Autowired
	private IRoleQxService roleQxService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IMFunctionService mfunctionService;
	
	@Autowired
	private IUserServices userService;
	
	/**
	 * 查询角色以及权限列表
	 */
	@RequestMapping(value="/queryRoleQx.htm")
	public String queryRoleQx(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException{
		User user = getUserSession(request);
		saveOperLog(user, MenuName.XTGL, MenuName.XTGL_QX, "查询角色权限", userService);
		StringBuffer objStr = new StringBuffer();
		
		List<Role> roleList = roleService.query("select obj from Role obj where 1=1 and is_delete = 0 "+objStr+"", null, -1, -1);//查角色列表
		
		//查菜单表
		List<Menu> menuList = menuService.query("select obj from Menu obj where is_delete = 0", null, -1, -1);
		
		//查菜单对应功能
		List<Mfunction> mfunctionList = mfunctionService.query("select obj from Mfunction obj where is_delete = 0", null, -1, -1);
		
		modelMap.addObject("roleList", roleList);
		modelMap.addObject("menuList", menuList);
		modelMap.addObject("mfunctionList", mfunctionList);
		
		return "/qx/qx_list";
	}
	
	@RequestMapping(value="/no/queryQx.htm")
	public String queryQx(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String id) throws IOException{
		List<RoleQx> roleQxList = new ArrayList<RoleQx>();
		//根据角色ID查询角色的权限
		if(id!=null && !id.equals("")){
		roleQxList = roleQxService.query("select obj from RoleQx obj where obj.rid = "+Long.parseLong(id)+"", null, -1, -1);
		}
		//查菜单表
		List<Menu> menuList = menuService.query("select obj from Menu obj where is_delete = 0", null, -1, -1);
		//查菜单对应功能
		List<Mfunction> mfunctionList = mfunctionService.query("select obj from Mfunction obj where is_delete = 0", null, -1, -1);
		
		modelMap.addObject("roleQxList", roleQxList);
		modelMap.addObject("menuList", menuList);
		modelMap.addObject("mfunctionList", mfunctionList);
		
		return "/qx/haveQx_list";
	}
	
	//保存权限
	@RequestMapping(value="/saveRoleQx.htm")
	public void saveRoleQx(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String rid,String function[]) throws IOException{
		User user = getUserSession(request);
		saveOperLog(user, MenuName.XTGL, MenuName.XTGL_QX, "保存角色权限", userService);
	
		
		Map<String,Object> map = new HashMap<String, Object>();
		if(rid == null || rid.equals("")){
			//ResponseAlertUtil.AlertMsg(response, "请选择角色", false, getServerPath(request)+"/admin/queryRoleQx.htm");
			map.put("flag", "1");
			map.put("errMsg", "请选择角色");
		}else{
			if(function==null || function.length == 0){
				//ResponseAlertUtil.AlertMsg(response, "请勾选角色权限", false, getServerPath(request)+"/admin/queryRoleQx.htm");
				map.put("flag", "1");
				map.put("errMsg", "请勾选角色权限");
			}else{
				//User user = getUserSession(request);
				
				//根据角色ID查询所有权限
				List<RoleQx> list = roleQxService.query("select obj from RoleQx obj where obj.rid = "+Long.parseLong(rid)+"", null, -1, -1);
				if(list!=null && list.size()>0){
					for(int i=0;i<list.size();i++){
						RoleQx objRoleQx = list.get(i);
						roleQxService.deleteRoleQx(objRoleQx.getId());//先删除
					}
				}
				
				//再增加
				for(int i=0;i<function.length;i++){
					Mfunction objMfunction = mfunctionService.getById(Long.parseLong(function[i]));
					RoleQx objRoleQx = new RoleQx();
					objRoleQx.setMid("0");
					objRoleQx.setRid(Long.parseLong(rid));
					objRoleQx.setMfunctionid(objMfunction.getId());
					objRoleQx.setUrl(objMfunction.getFunctionurl());
					roleQxService.save(objRoleQx);
				}
				
				map.put("flag", "0");
				
			}
		}
		
		response.getWriter().print(JsonUtil.parseJSON(map));
		
	}
}
