package com.org.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.SellerDao;
import com.org.dto.Seller;
import com.org.dto.User;
@Component
public class SellerDaoImpl implements SellerDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("P");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	@Override
	public void saveSeller(Seller seller) {
		et.begin();
		em.merge(seller);
		et.commit();
		
	}
	@Override
	public Seller fetchSellerByEmailAndPassword(String email, String password) {
		String jpql="select u from Seller u where u.email=?1 and u.password=?2";
		Query q=em.createQuery(jpql);
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<Seller> u=q.getResultList();
		Seller u1=new Seller();
		for (Seller user : u) {
			u1.setId(user.getId());
			u1.setName(user.getName());
			u1.setMobile(user.getMobile());
			u1.setAddress(user.getAddress());
			u1.setEmail(user.getEmail());
			u1.setPassword(user.getPassword());
			
		}
		return u1;
	}
	@Override
	public Seller fetchSellerById(int id) {
		return em.find(Seller.class, id);
	}

}
