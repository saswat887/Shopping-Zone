package com.org.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.ItemDao;
import com.org.dto.Item;
import com.org.dto.Product;
import com.org.dto.Seller;
import com.org.dto.User;
@Component
public class ItemDaoImpl implements ItemDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("P");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	@Override
	public void saveAndUpdateItem(Item item) {
		et.begin();
		em.merge(item);
		et.commit();
		
	}
	@Override
	public Item fetchItemById(int id) {
		
		return em.find(Item.class, id);
	}
	@Override
	public List<Item> fetchAllItems() {
		String jpql="select u from Item u";
		Query q=em.createQuery(jpql);
		List<Item> u=q.getResultList();

		return u;
	}
	@Override
	public void deleteItems(int id) {
		Item product=em.find(Item.class, id);
		User seller=product.getUser();
		List<Item> products=seller.getItems();
		products.remove(product);
		et.begin();
		em.remove(product);
		em.merge(seller);
		et.commit();
		
	}
	@Override
	public void stockLeft(int id) {
		Product product=em.find(Product.class, id);
		
	}

}
