package com.org.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.ItemDao;
import com.org.dao.ProductDao;
import com.org.dao.UserDao;
import com.org.dto.Item;
import com.org.dto.Product;
import com.org.dto.User;

@Controller
public class ItemController {
	@Autowired
	ProductDao productDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ItemDao itemDao;
	
	@GetMapping("/add_item")
	public ModelAndView addItem(@RequestParam int productId,HttpSession session)
	{
		Product product=productDao.fetchProductById(productId);
		Item item=new Item();
		item.setName(product.getName());
		item.setCategory(product.getCategory());
		item.setDescription(product.getDescription());
		item.setPrice(product.getPrice());
		item.setStockLeft(product.getStockLeft());
		
		int userId=(int) session.getAttribute("userId");
		
		User user=userDao.fetchUserById(userId);
		
		List<Item> items=user.getItems();
		items.add(item);
		
		item.setUser(user);
		user.setItems(items);
		
		itemDao.saveAndUpdateItem(item);
		
		ModelAndView mav=new ModelAndView("user/user_home.jsp");
		mav.addObject("success","Product Added to Cart Successfully");
		return mav;
		
	}
	@GetMapping("/delete_item")
	public ModelAndView deleteProduct(@RequestParam int itemId)
	{
		itemDao.deleteItems(itemId);
		ModelAndView mav=new ModelAndView("user/view_products.jsp");
		return mav;
	}
	@GetMapping("/buy_item")
	public ModelAndView buyItem(@RequestParam int itemId)
	{
		Item item=new Item();
		itemDao.stockLeft(itemId);
		return null;
	}

}