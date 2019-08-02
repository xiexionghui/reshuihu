package org.framework.business.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseAlertUtil {
	/**
	 * 后台弹出对话框
	 * @param response
	 * @param msg
	 * @param backFlag 是否返回上一页面，默认为false
	 * @param backUrl 返回路径
	 * @throws IOException
	 */
	public static void AlertMsg(HttpServletResponse response,String msg,boolean backFlag,String backUrl) throws IOException{
		response.setContentType("text/html; charset=UTF-8"); //转码
	    PrintWriter out = response.getWriter();
	    out.flush();
	    out.println("<script>");
	    out.println("alert('"+msg+"');");
	    if(backFlag){
	    	out.println("history.back();");
	    }else if(!"".equals(backUrl) && null != backUrl){//为false 则返回路径
	    	out.println("window.location.href='"+backUrl+"';");
	    }
	    out.println("</script>");
	}
}
