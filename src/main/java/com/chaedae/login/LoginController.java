package com.chaedae.login;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaedae.model.User;
import com.chaedae.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/chaedae/login/login.cd")
	public String login() {
		return "/chaedae/login/Login";
	}
	
	@PostMapping(value = "/chaedae/login/loginProc.json")
	@ResponseBody
	public void loginProc(User vo, HttpServletResponse response) throws Exception {
		String rtn = "FAILURE";
		if (vo != null && vo.getUserId() != null) {
			User user = userService.selectByUserId(vo);
			
			if (user != null && user.getPwd().equals(vo.getPwd())) {
				rtn = "SUCCESS";
			}
		}
		
		response.getWriter().print(rtn);
	}
}
