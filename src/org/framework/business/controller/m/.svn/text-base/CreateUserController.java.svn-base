package org.framework.business.controller.m;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.Md5Crypt;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.IUserServices;
import org.framework.business.util.Md5Encrypt;
import org.framework.xcode.spring.interceptor.MyFrameworkInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateUserController  extends MyFrameworkInterceptor {
	@Autowired
	private IUserServices userService;
	
	@RequestMapping(value="/createUser.htm")
	public void createUser(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,String name) throws IOException{
		User user = new User();
		user.setUserName(name);
		user.setPassword(Md5Encrypt.md5("123456"));
		user.setNickName("admin");
		user.setMobile("13710101010");
		user.setEmail("");
		user.setStatus(0l);
		user.setAddTime(new Date());
		user.setIs_admin(1);
		user.setRid("0");
		userService.save(user);
		response.getWriter().print(1111);
		
	}

}
