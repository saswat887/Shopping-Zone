package com.org.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.UserDao;
import com.org.dto.User;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@PostMapping("/register_user")
	public ModelAndView registerSeller(@ModelAttribute User user)
	{
		ModelAndView mav=new ModelAndView("user/user_login.jsp");
		userDao.saveUser(user);
		return mav;
	}
	@PostMapping("/user_login")
	public ModelAndView sellerlogin(@RequestParam String email,@RequestParam String password,HttpSession session)
	{
		User s=userDao.fetUserByEmailAndPassword(email, password);
		System.out.println(s.getId());
		if(s.getId()!=0)
		{
			System.out.println("Hello");
			session.setAttribute("userId", s.getId());
			ModelAndView mav=new ModelAndView("user/user_home.jsp");
			return mav;
		}
		else
		{
			ModelAndView mav=new ModelAndView("user/user_login.jsp");
			mav.addObject("wrong","INVALID CREDENTIAL");
			return mav;
		}
	}
	@RequestMapping("/user_logout")
	public ModelAndView sellerlogout(HttpSession session)
	{
		ModelAndView mav=new ModelAndView("user/user_login.jsp");
		session.removeAttribute("userId");
		session.invalidate();
		return mav;
	}

}
