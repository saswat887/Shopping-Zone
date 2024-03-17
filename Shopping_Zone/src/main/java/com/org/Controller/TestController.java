package com.org.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.dto.Product;
import com.org.dto.Seller;
import com.org.dto.User;

@Controller
public class TestController {
		@GetMapping("/emptyUser")
		public ModelAndView emptyUser()
		{
			User user=new User();
			ModelAndView mav=new ModelAndView("user/user_register.jsp");
			mav.addObject("user",user);
			return mav;
		}
		@GetMapping("/emptySeller")
		public ModelAndView emptySeller()
		{
			Seller seller=new Seller();
			ModelAndView mav=new ModelAndView("seller/seller_register.jsp");
			mav.addObject("seller",seller);
			return mav;
		}
		@GetMapping("/emptyProduct")
		public ModelAndView emptyProduct()
		{
			System.out.println("empty executed");
			Product product=new Product();
			ModelAndView mav=new ModelAndView("seller/add_products.jsp");
			mav.addObject("product",product);
			return mav;
		}
}
