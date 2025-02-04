package com.pathlock.sping.data.jpa.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pathlock.sping.data.jpa.api.dao.UserRepository;
import com.pathlock.sping.data.jpa.api.model.User;

@Service
@Transactional
public class UserService {
    @Autowired
	private UserRepository userRepository;
    
    @PostConstruct
    public void addUser() {
    	List<User> userList= new ArrayList<User>();
    	userList.add(new User(308,"shankar","IT",30));
    	userList.add(new User(102,"shiv","TOMP",3));
    	userList.add(new User(202,"sona","SOM",70));
    	userList.add(new User(504,"appa","IT",15));
    	userList.add(new User(305,"rohit","IT",88));
    	userList.add(new User(702,"sam","MECH",32));
    	userList.add(new User(902,"pal","IT",11));
    	userList.add(new User(502,"jan","ENG",10));
    	userRepository.saveAll(userList);
    	System.out.println("saved success");
    }
    
	public List<User> getAllUsers(){
	return	userRepository.findAll();
	}
	
	public List<User> findByProfession(String profession){
		return userRepository.findByProfession(profession);
	}
	
	public long countByAge(int age) {
		return userRepository.countByAge(age);
	}
	
	public List<User> deleteByName(String name) {
		return userRepository.deleteByName(name);
	}
	
	public List<User> findByProfessionAndAge(String profession,int age){
	return	userRepository.findByProfessionAndAge(profession, age);
	}
	
	public List<User> findByProfessionIgnoreCase(String profession){
		return userRepository.findByProfessionIgnoreCase(profession);
	}
	

	/*
	 * public Page<User> getPagination(int page , int size){ return
	 * userRepository.findAll(new PageRequest); }
	 */

	 public Page<User> getPagination(Pageable pageable){ 
		return userRepository.findAll(pageable);
	 }
	
	public List<User> getUserFromCustomQuery(){
		return userRepository.getUserByCustomQuery();
	}
}
