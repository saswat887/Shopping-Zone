package com.org.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.ProductDao;
import com.org.dao.SellerDao;
import com.org.dto.Product;
import com.org.dto.Seller;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	SellerDao sellerDao;
	
	@PostMapping("/add_product")
	public ModelAndView addProduct(@ModelAttribute Product product,HttpSession session)
	{
		ModelAndView mav=new ModelAndView("seller/add_products.jsp");
		int sellerId=(int)session.getAttribute("sellerId");
		Seller seller=sellerDao.fetchSellerById(sellerId);
		List<Product> products=seller.getProducts();
		products.add(product);
		product.setSeller(seller);
		seller.setProducts(products);
		productDao.saveAndUpdateProduct(product);
		mav.addObject("success","Product Added Successfully");
		return mav;
	}
	@GetMapping("/update_product")
	public ModelAndView sendProductData(@RequestParam int productId)
	{
		Product product=productDao.fetchProductById(productId);
		ModelAndView mav=new ModelAndView("seller/add_products.jsp");
		mav.addObject("product",product);
		return mav;
	}
	@GetMapping("/delete_product")
	public ModelAndView deleteProduct(@RequestParam int productId)
	{
		productDao.deletePersonById(productId);
		ModelAndView mav=new ModelAndView("seller/veiw_products.jsp");
		return mav;
	}

}
