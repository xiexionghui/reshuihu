package org.framework.business.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.business.model.entity.Function;
import org.framework.business.model.entity.Menu;
import org.framework.business.model.entity.Mfunction;
import org.framework.business.model.entity.Role;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.IFunctionService;
import org.framework.business.model.service.IMFunctionService;
import org.framework.business.model.service.IMenuService;
import org.framework.business.util.PageUtil;
import org.framework.business.util.ResponseAlertUtil;
import org.framework.xcode.spring.interceptor.MyFrameworkInterceptor;
import org.framework.business.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class MenuManagerController extends MyFrameworkInterceptor{
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IMFunctionService mfunctionService;
	
	@Autowired
	private IFunctionService functionService;
	
	/**
	 * 分页查询所有菜单
	 */
	@RequestMapping(value="/queryMenu.htm")
	public String queryMenu(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String page,String name){
		StringBuffer objStr=new StringBuffer();
		if(name!=null && !name.equals("")){
			objStr.append(" and mname like '%"+name+"%' ");
		}
		
		PageList<Menu> pageList = new PageList<Menu>();
		if(page == null || page.equals("")){
			page="1";	
		}
		
		objStr.append(" and is_delete = 0");
		
		pageList = menuService.queryMenuPage(objStr.toString(), null, (Integer.parseInt(page)-1)*pageList.getPageSize(), pageList.getPageSize(), Integer.parseInt(page));
		PageUtil.savePageModelMap("", "", "", pageList, modelMap);
		modelMap.addObject("name", name);
		return "/admin/menu_list";
	}
	
	/**
	 * 删除菜单
	 * @throws IOException 
	 */
	@RequestMapping(value="/delMenu.htm")
	public void delMenu(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String id) throws IOException{
		List<Mfunction> list = mfunctionService.query("select obj from Mfunction obj where obj.menuid = "+Long.parseLong(id)+"", null, -1, -1);//查询菜单功能
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				Mfunction objMfunction = list.get(i);
				objMfunction.setIs_delete(1);//逻辑删除
				mfunctionService.update(objMfunction);
			}
		}
		
		Menu menu = menuService.getById(Long.parseLong(id));
		menu.setIs_delete(1);
		menuService.update(menu);
		
		ResponseAlertUtil.AlertMsg(response, "操作成功", false, getServerPath(request)+"/admin/queryMenu.htm");
	}
	
	
	/**
	 * 跳转到新增菜单页面
	 */
	@RequestMapping(value="/no/addMenu.htm")
	public String addMenu(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
		List<Function> functionList = functionService.query("select obj from Function obj where obj.is_delete = 0", null, -1, -1);
		modelMap.addObject("functionList", functionList);
		if(functionList!=null && functionList.size()>0){
			modelMap.addObject("functionListSize", 1);
		}else{
			modelMap.addObject("functionListSize", 0);
		}
		return "/admin/add_menu";
	}
	
	/**
	 * 新增菜单
	 * @throws IOException 
	 */
	@RequestMapping(value="/saveMenu.htm")
	public void saveMenu(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String mname,String id,String functionid[],String url[]) throws IOException{
		if(functionid!=null && functionid.length>0){
			Menu menu=new Menu();
			Menu mes = menuService.queryByName(mname);
				if(mes != null && mes.getId() != null){
					ResponseAlertUtil.AlertMsg(response, "操作失败，菜单名已存在！", false, getServerPath(request)+"/admin/saveMenu.htm");	
					return ;
				}
			menu.setMname(mname);
			menuService.save(menu);
			for(int i=0;i<functionid.length;i++){
				Mfunction mfunction = new Mfunction();
				mfunction.setMenuid(menu.getId());//菜单ID
				mfunction.setFunctionid(Long.parseLong(functionid[i]));
				mfunction.setFunctionurl(url[i]);
				mfunction.setFunctionname(functionService.getById(Long.parseLong(functionid[i])).getFname());
				mfunctionService.save(mfunction);
			}
			ResponseAlertUtil.AlertMsg(response, "操作成功", false, getServerPath(request)+"/admin/queryMenu.htm");
		}else{
			ResponseAlertUtil.AlertMsg(response, "操作失败:请选择菜单功能", false, getServerPath(request)+"/admin/addMenu.htm");
		}
		
	}
	
	
}
