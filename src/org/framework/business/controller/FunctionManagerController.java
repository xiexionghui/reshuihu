package org.framework.business.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.business.model.entity.Function;
import org.framework.business.model.service.IFunctionService;
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
public class FunctionManagerController  extends MyFrameworkInterceptor{
	@Autowired
	private IFunctionService functionService;
	
	/**
	 * 分页查功能
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/queryFunction.htm")
	public String queryFunction(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String name,String page){
		
		StringBuffer objStr=new StringBuffer();
		if(name!=null && !name.equals("")){
			objStr.append(" and fname like '%"+name+"%' ");
		}
		
		PageList<Function> pageList = new PageList<Function>();
		if(page == null || page.equals("")){
			page="1";	
		}
		objStr.append(" and is_delete = 0");
		
		pageList = functionService.queryFunctionPage(objStr.toString(), null, (Integer.parseInt(page)-1)*pageList.getPageSize(), pageList.getPageSize(), Integer.parseInt(page));
		PageUtil.savePageModelMap("", "", "", pageList, modelMap);
		modelMap.addAttribute("name", name);
		return "/admin/function_list";
	}
	
	/**
	 * 跳转到新增功能页面
	 */
	@RequestMapping(value="/no/addFunction.htm")
	public String addFunction(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
		return "/admin/add_function";
	}
	
	/**
	 * 新增功能
	 * @throws IOException 
	 */
	@RequestMapping(value="/saveFunction.htm")
	public void saveFunction(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String fname,String id) throws IOException{
		Function fun = functionService.getByName(fname);
		if(id == null || id.equals("")){//新增
			if(null!=fun){
				ResponseAlertUtil.AlertMsg(response, "功能已存在", false, getServerPath(request)+"/admin/queryFunction.htm");
				return;
			}
			Function objFunction = new Function();
			objFunction.setFname(fname);
			functionService.save(objFunction);
		}else{//修改
			if(null!=fun && fun.getId().toString().equals(id)){
				Function function = functionService.getById(Long.parseLong(id));
				function.setFname(fname);
				functionService.update(function);
			}else{
				ResponseAlertUtil.AlertMsg(response, "功能已存在", false, getServerPath(request)+"/admin/queryFunction.htm");
				return;
			}
		}
		ResponseAlertUtil.AlertMsg(response, "操作成功", false, getServerPath(request)+"/admin/queryFunction.htm");
	}
	
	/**
	 * 删除功能
	 * @throws IOException 
	 */
	@RequestMapping(value="/delFunction.htm")
	public void delFunction(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String id) throws IOException{
		Function function = functionService.getById(Long.parseLong(id));
		function.setIs_delete(1);
		functionService.update(function);
		ResponseAlertUtil.AlertMsg(response, "操作成功", false, getServerPath(request)+"/admin/queryFunction.htm");
	}
	
	/**
	 * 编辑功能
	 * 
	 */
	@RequestMapping(value="/toUpdateFunction.htm")
	public String toUpdateFunction(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String id){
		Function function = functionService.getById(Long.parseLong(id));
		modelMap.addObject("function", function);
		return "/admin/add_function";
	}
	
}
