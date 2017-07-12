package com.zgp.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgp.dao.UserMapper;
import com.zgp.domain.User;
import com.zgp.domain.UserExample;
import com.zgp.user.service.userService;
import com.zgp.vo.UserPwdVO;

import yanzhengma.Verify;
import yanzhengma.VerifyCode;

@Controller
public class userController {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private userService userService;
	@RequestMapping(value="/test1")
	public void test1(HttpServletRequest request,HttpServletResponse response){
		User user = userMapper.selectByPrimaryKey("XXX");
		System.out.println(user.getLoginname());
		return;
	}
	
	
	//获取验证码
	
	@RequestMapping(value="/getverify")
	public void getVerify(HttpServletRequest request,HttpServletResponse response){
		try {
			Verify.getVirify(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	
	
	@RequestMapping(value="/valiloginname")
	public void valiloginname(HttpServletRequest request,HttpServletResponse response, String loginname) throws Exception{
		
		UserExample example = new UserExample();
		example.createCriteria().andLoginnameEqualTo(loginname);
		List<User> users = userMapper.selectByExample(example);
		
		if (users.size()==0) {
			response.getWriter().print("true");
		}else {
			response.getWriter().print("false");
		}
		return ;
	}
	
	
	@RequestMapping(value="/valiemail")
	public @ResponseBody Boolean valiemail(String email) throws Exception{
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		List<User> users = userMapper.selectByExample(example);
		if (users.size()==0) {
			return true;
		}
		return false;
	}
	@RequestMapping(value="/verifycodeerror")
	public @ResponseBody Boolean verifycodeerror(HttpServletRequest request,String verifyCodevalue) throws Exception{
		String vCode = (String) request.getSession().getAttribute("vCode");
		if (vCode.equalsIgnoreCase(verifyCodevalue)) {
			return true;
		}
		return false;
		
	}
	
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user,Model model){
		userService.regist(user);
		model.addAttribute("code", "success");
		model.addAttribute("msg", "注册成功，请到邮箱激活");
		return "/jsps/msg";
	}
	
	@RequestMapping(value="/activation",method=RequestMethod.GET)
	public String activation(String activationCode,Model model){
		UserExample example = new UserExample();
		example.createCriteria().andActivationcodeEqualTo(activationCode);
		List<User> users = userMapper.selectByExample(example);
		if (users.size()==0) {
			model.addAttribute("code", "error");
			model.addAttribute("msg", "激活失败");
		}else {
			if (users.get(0).getStatus()) {
				model.addAttribute("code", "error");
				model.addAttribute("msg", "不要重复激活");
			} else {
				model.addAttribute("code", "success");
				model.addAttribute("msg", "激活成功");
				userService.verifyactivationCode(users);
			}
		}
		return "/jsps/msg";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpSession session,Model model){
		List<User> users = userService.selectuser(user);
		System.out.println(users);
		if (users.size()!=0) {
			if (users.get(0).getStatus()!=false) {
				session.setAttribute("user", users.get(0));
				return   "redirect:jsps/main.jsp";
			} else {
				model.addAttribute("msg", "当前账户未激活，请到邮箱中激活");
				model.addAttribute("error_user", user);
				return   "jsps/user/login";
			}	
		}
		model.addAttribute("msg", "用户名或者密码错误");
		model.addAttribute("error_user", user);
		return  "jsps/user/login";
	}
	
	@RequestMapping(value="/loginquit")
	public String loginquit(HttpSession session){
		session.invalidate();
		return "jsps/user/login";
	}
	
	
	@RequestMapping(value="/editpwd/{uid}",method=RequestMethod.PUT)
	public String editpwd(@PathVariable String uid,UserPwdVO vo,Model model,HttpSession session){
		
		Boolean b  =  userService.editpwd(uid,vo);
		if (b) {
			model.addAttribute("msg", "密码修改成功！");
			model.addAttribute("code", "success");
			session.invalidate();
			return "/jsps/msg";
		}
		model.addAttribute("msg", "密码修改失败！");
		model.addAttribute("code", "error");
		return "/jsps/msg";
	}
	
	
}
