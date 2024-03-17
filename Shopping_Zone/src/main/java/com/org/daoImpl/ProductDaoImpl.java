package com.org.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.ProductDao;
import com.org.dto.Item;
import com.org.dto.Product;
import com.org.dto.Seller;
import com.org.dto.User;
@Component
public class ProductDaoImpl implements ProductDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("P");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	@Override
	public void saveAndUpdateProduct(Product product) {
		et.begin();
		em.merge(product);
		et.commit();
		
	}

	@Override
	public Product fetchProductById(int id) {

		return em.find(Product.class, id);
	}

	@Override
	public List<Product> fetchAllProduct() {
		String jpql="select u from Product u";
		Query q=em.createQuery(jpql);
		List<Product> u=q.getResultList();

		return u;
	}

	@Override
	public void deletePersonById(int id) {
		Product product=em.find(Product.class, id);
		Seller seller=product.getSeller();
		List<Product> products=seller.getProducts();
		products.remove(product);
		et.begin();
		em.remove(product);
		em.merge(seller);
		et.commit();
		
	}

}
