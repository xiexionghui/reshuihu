package org.framework.business.util;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.Enumeration;
import java.util.List;

import javax.servlet.FilterChain;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import org.framework.business.model.entity.RoleQx;
import org.framework.business.model.entity.User;
import org.springframework.web.filter.OncePerRequestFilter;  

/** 
 * 登录过滤 以及权限验证
 * @author zhuth 
 * @date 2015-09-06 10:37:38 
 */  
public class SessionFilter extends OncePerRequestFilter {  

	@Override  
    protected void doFilterInternal(HttpServletRequest request,  
            HttpServletResponse response, FilterChain filterChain)  
            throws ServletException, IOException {  
		request.setCharacterEncoding("UTF-8");
        // 不过滤的url  
        String[] notFilter = new String[] { "admin/login.htm","/admin/queryIndex.htm","/admin/welcome.htm","admin/index.htm","admin/left.htm","admin/top.htm","admin/right.htm","admin/footer.htm","admin/loginout.htm","admin/no"};  
        
        //请求的url  
        String url = request.getRequestURI();  
        if(url.indexOf("/admin") == -1){//是前台
////        	获得所有请求参数名  
//            Enumeration params = request.getParameterNames();  
//            String sql = "";  
//            while (params.hasMoreElements()) {  
//                //得到参数名  
//                String name = params.nextElement().toString();  
//                //System.out.println("name===========================" + name + "--");
//                //得到参数对应值  
//                String[] value = request.getParameterValues(name);  
//                for (int i = 0; i < value.length; i++) {  
//                    sql = sql + new String(value[i]);  
//                }  
//            }  
//            
//            if(sqlValidate(sql)){
//            	 throw new IOException("您发送请求中的参数中含有非法字符");  
//            }else{
        		filterChain.doFilter(request, response);  
			//}
        }else{//后台过滤
        	  
            // 是否过滤  
            boolean doFilter = true;  
            for (String s : notFilter) {  
                if (url.indexOf(s) != -1) {  
                    // 如果url中包含不过滤的url，则不进行过滤  
                    doFilter = false;  
                    break;  
                }  
            }  
            if (doFilter) {// 执行过滤
            	
            	// 设置request和response的字符集，防止乱码  
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();

                // 从session中获取登录者实体
                User obj = (User)request.getSession().getAttribute("user");
                if (null == obj) {  
                    // 如果session中不存在登录者实体，则弹出框提示重新登录  
                    String loginPage = getServerPath(request)+"/admin/index.htm";  
                    StringBuilder builder = new StringBuilder();  
                    builder.append("<script type=\"text/javascript\">");  
                    builder.append("alert('请重新登录');");  
                    builder.append("window.top.location.href='");  
                    builder.append(loginPage);  
                    builder.append("';");  
                    builder.append("</script>");  
                    out.print(builder.toString());  
                    
                } else {  
                    // 如果session中存在登录者实体或者用户是管理员则继续   用户ID为0代表是前台访问
                	if(url.indexOf("admin/left.htm") != -1 || obj.getIs_admin() == 1 || url.indexOf("admin/no") != -1){
                		filterChain.doFilter(request, response);
                	}else{//判断用户权限
                		//根据用户对应角色查询用户权限
                		if(obj.getRid() == null || obj.getRid().equals("") || obj.getRid().equals("null")){//没有选择角色信息  直接返回
                			String indexPage = getServerPath(request)+"/admin/welcome.htm";  
                			 StringBuilder builder = new StringBuilder();  
                			 builder.append("<script type=\"text/javascript\">");  
                             builder.append("alert('权限不足，请联系管理员');");  
                             //builder.append("history.back();");  
                            // builder.append("location.reload();");
                             builder.append("window.location.href='");  
                             builder.append(indexPage);  
                             builder.append("';");  
                             builder.append("</script>");  
                             out.print(builder.toString());  
                		}else{
                			boolean flag = false;
                			List<RoleQx> qxList = (List<RoleQx>)request.getSession().getAttribute("qxList");
                			if(qxList!=null && qxList.size()>0){
                				for(int i=0;i<qxList.size();i++){
                					RoleQx objRoleQx = qxList.get(i);
                					if(url.indexOf(objRoleQx.getUrl()) != -1){//有权限
                    					flag = true;
                    					break;
                    				}
                				}
                			}
                			
                				
                			if(flag == false){//没有权限
                				StringBuilder builder = new StringBuilder();  
                       			builder.append("<script type=\"text/javascript\">");  
                                builder.append("alert('权限不足，请联系管理员');");  
                                builder.append("history.back();");  
                                builder.append("</script>");  
                                out.print(builder.toString());  
                			}else{
                        		filterChain.doFilter(request, response);  
                			}
                			
                		}
                	}
                	
                	
                }  
            } else {  
                // 如果不执行过滤，则继续  
                filterChain.doFilter(request, response);  
            }  
        
        }
        
        
        
    }  
  
	
//	效验  
    protected static boolean sqlValidate(String str) {  
        str = str.toLowerCase();//统一转为小写  
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +  
                "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +  
                "table|from|grant|use|group_concat|column_name|" +  
                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +  
                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";//过滤掉的sql关键字，可以手动添加  
        String[] badStrs = badStr.split("\\|");  
        for (int i = 0; i < badStrs.length; i++) {  
            if (str.indexOf(badStrs[i]) >= 0) {  
                return true;  
            }  
        }  
        return false;  
    }  
    
    
    protected String getServerPath(HttpServletRequest request){
    	return Configuration.getValue("site_url");
	}

}   