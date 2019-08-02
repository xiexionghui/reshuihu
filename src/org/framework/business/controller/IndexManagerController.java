package org.framework.business.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.framework.business.model.entity.User;
import org.framework.business.model.service.IRoleQxService;
import org.framework.business.model.service.IUserServices;
import org.framework.business.util.ImageResizer;
import org.framework.business.util.Md5Encrypt;
import org.framework.business.util.ResponseAlertUtil;
import org.framework.xcode.spring.interceptor.MyFrameworkInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping(value = "/admin")
public class IndexManagerController extends MyFrameworkInterceptor{
	@Autowired
	private IUserServices userService;
	@Autowired
	private IRoleQxService roleQxService;

	@RequestMapping(value="/left.htm")
	public String left(HttpServletRequest request,HttpServletResponse response,InputStream is) throws IOException{
		return "/user/left";
	}
	@RequestMapping(value="/top.htm")
	public String top(HttpServletRequest request,HttpServletResponse response,InputStream is) throws IOException{
		return "/user/top";
	}
	
	@RequestMapping(value="/no/upPwd.htm")
	public String upPwd(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException{
	
		return "/user/update_pwd";
	}
	
	@RequestMapping(value="/no/updateMyPwd.htm")
	public String updateMyPwd(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,String password,String oldpassword) throws IOException{
		User user = getUserSession(request);
		if(user.getPassword().equals(Md5Encrypt.md5(oldpassword))){
			user.setPassword(Md5Encrypt.md5(password));
			userService.update(user);
			saveUserSession(request, user);
			String msg="操作成功";
			ResponseAlertUtil.AlertMsg(response, msg, true, getServerPath(request)+"/admin/queryIndex.htm");
			return null; 
		}else{
			String msg="原密码有误";
			ResponseAlertUtil.AlertMsg(response, msg, false, getServerPath(request)+"/admin/queryIndex.htm");
			return null; 
		}
		
	}
	
	
	@RequestMapping(value="/right.htm")
	public String right(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException{
	
		return "/user/right";
	}
	
	
	@RequestMapping(value="/welcome.htm")
	public String welcome(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException{
	
		return "/user/welcome";
	}
	
	
	
	
	
	@RequestMapping(value="/footer.htm")
	public String footer(HttpServletRequest request,HttpServletResponse response,InputStream is) throws IOException{
		return "/user/footer";
	}
	
	@RequestMapping(value="/nav.htm")
	public String nav(HttpServletRequest request,HttpServletResponse response,InputStream is) throws IOException{
		return "/user/nav";
	}
	
	
	
	
	/**
	 * 根据用户ID查用户信息
	 */
	@RequestMapping(value="/index.htm")
	public String index(HttpServletRequest request,HttpServletResponse response,InputStream is,ModelMap modelMap) throws IOException{

		return "/user/login";
	}
	
	@RequestMapping(value="/queryIndex.htm")
	public String queryIndex(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,InputStream is) throws IOException{
		
		return "/user/main";
	}
	
	
	
	
	@RequestMapping(value="/login.htm")
	public String login(HttpServletRequest request,HttpServletResponse response,InputStream is,String name,String pwd,String loginNum) throws IOException{
		
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("userName", name);
			map.put("password", Md5Encrypt.md5(pwd));
			List<User> list = userService.queryUser("select obj from User obj where userName = :userName and password =:password and is_delete = 0 and status = 0", map, -1, -1);
			
			if(list!=null && list.size()>0){
				User user = list.get(0);
				try {
					saveUserSession(request, user);
					saveAdminSessionQx(request, roleQxService, user);
				} catch (Exception e) {
						e.printStackTrace();
				}
//				String msg="登陆成功";
//				ResponseAlertUtil.AlertMsg(response, msg, false, getServerPath(request)+"/admin/queryIndex.htm");
//				return null; 
				return "/user/main";
			}else{
				ResponseAlertUtil.AlertMsg(response, "账号密码有误", false, getServerPath(request)+"/admin/index.htm");
				return null; 
			}
		
		
		
	}
	
	
	
	/**
	 * 修改密码
	 */
	@RequestMapping(value="/no/toUpdatePwd.htm")
	public String toUpdatePwd(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String id){
		return "/user/update_pwd";
	}
	
	
	/**
	 * /updatePwd.htm
	 * @throws IOException 
	 */
	@RequestMapping(value="/no/updatePwd.htm")
	public String updatePwd(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String pwd,String newpwd) throws IOException{
		User user = getUserSession(request);
		if(Md5Encrypt.md5(pwd.trim()).equals(user.getPassword())){
			user.setPassword(Md5Encrypt.md5(newpwd.trim()));
			userService.update(user);
			saveUserSession(request, user);
			ResponseAlertUtil.AlertMsg(response, "操作成功", true, getServerPath(request)+"/admin/queryUser.htm");
			return null; 
		}else{
			ResponseAlertUtil.AlertMsg(response, "无权操作", true, getServerPath(request)+"/admin/queryUser.htm");
			return null; 
		}
	}
	
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/loginout.htm")
	public String loginout(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		ResponseAlertUtil.AlertMsg(response, "退出成功", false, getServerPath(request)+"/admin/index.htm");
		return null; 
	}
	
	
	/**
	 * ajax图片上传
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 */
    @RequestMapping(value="/no/fileUpload.htm")
    public void fileUpload(@RequestParam MultipartFile[] myfiles, HttpServletRequest request, HttpServletResponse response) throws Exception{
    	java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyyMMdd");
        String date = format1.format(new Date());
        String realPath = request.getSession().getServletContext().getRealPath("/fileUpload")+"/"+date;
        File file =new File(realPath);    
        //如果文件夹不存在则创建    
        if(!file.exists()&&!file.isDirectory())      
        {       
          file.mkdir();    
        }  
        //设置响应给前台内容的数据格式
        response.setContentType("text/plain; charset=UTF-8");
        //设置响应给前台内容的PrintWriter对象
        PrintWriter out = response.getWriter();
        //上传文件的原名(即上传前的文件名字)
        String originalFilename = null;
        //如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
        //如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
        //上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
        for(MultipartFile myfile : myfiles){
            if(myfile.isEmpty()){
                out.print("1`请选择文件后上传");
                out.flush();
            }else{
            	UUID uuid = UUID.randomUUID();
                originalFilename = uuid+".jpg";//myfile.getOriginalFilename();
                try {
                	myfile.transferTo(new File(realPath, originalFilename));
                	ImageResizer.resizeImage(realPath+"/"+originalFilename, realPath+"/"+originalFilename, 180, 155);
                } catch (IOException e) {
                    System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
                    e.printStackTrace();
                    out.print("1`文件上传失败，请重试！！");
                    out.flush();
                }
            }
        }
        //"0`" + request.getContextPath() + "/fileUpload/"+date+"/" + originalFilename
        out.print("0`" + "fileUpload/"+date+"/" + originalFilename);
        out.flush();
    }
    
    
    
}
