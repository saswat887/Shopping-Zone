package com.org.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.SellerDao;
import com.org.dto.Seller;

@Controller
public class SellerController {
	@Autowired
	private SellerDao sellerDao;
	
	@PostMapping("/register_seller")
	public ModelAndView registerSeller(@ModelAttribute Seller seller)
	{
		ModelAndView mav=new ModelAndView("seller/seller_login.jsp");
		sellerDao.saveSeller(seller);
		return mav;
	}
	@PostMapping("/seller_login")
	public ModelAndView sellerlogin(@RequestParam String email,@RequestParam String password,HttpSession session)
	{
		Seller s=sellerDao.fetchSellerByEmailAndPassword(email, password);
		System.out.println(s.getId());
		if(s.getId()!=0)
		{
			System.out.println("Hello");
			session.setAttribute("sellerId", s.getId());
			ModelAndView mav=new ModelAndView("seller/seller_homepage.jsp");
			return mav;
		}
		else
		{
			ModelAndView mav=new ModelAndView("seller/seller_login.jsp");
			mav.addObject("wrong","INVALID CREDENTIAL");
			return mav;
		}
	}
	@RequestMapping("/seller_logout")
	public ModelAndView sellerlogout(HttpSession session)
	{
		ModelAndView mav=new ModelAndView("seller/seller_login.jsp");
		session.removeAttribute("sellerId");
		session.invalidate();
		return mav;
	}

}
