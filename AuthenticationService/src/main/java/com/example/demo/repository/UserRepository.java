package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{

	//@PersistenceContext
	//private EntityManager entityManager;

	
	
	/*public User findByName(String username) {
		return entityManager.createQuery("SELECT user FROM User user WHERE user.username = :username", User.class)
				.setParameter("username", username).getSingleResult();
	}

	@Transactional
	public void save(User user) {
		entityManager.persist(user);
	}
	*/
	
	
	 Optional<User> findByName(String username);
	

}



