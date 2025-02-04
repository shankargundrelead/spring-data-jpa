package com.pathlock.sping.data.jpa.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pathlock.sping.data.jpa.api.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByProfession(String profession);
	
	public long countByAge(int age);
	
	List<User> deleteByName(String name);
	
	List<User> findByProfessionAndAge(String profession ,int age);
	
	List<User> findByProfessionIgnoreCase(String profession);
	
	@Query("select u from User u")
	List<User> getUserByCustomQuery();
}
