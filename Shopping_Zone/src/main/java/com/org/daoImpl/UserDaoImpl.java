package com.org.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.UserDao;
import com.org.dto.User;
@Component
public class UserDaoImpl implements UserDao{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("P");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();

	@Override
	public void saveUser(User user) {
		et.begin();
		em.merge(user);
		et.commit();	
	}

	@Override
	public User fetUserByEmailAndPassword(String email, String password) {
		String jpql="select u from User u where u.email=?1 and u.password=?2";
		Query q=em.createQuery(jpql);
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<User> u=q.getResultList();
		User u1=new User();
		for (User user : u) {
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
	public User fetchUserById(int id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

}
