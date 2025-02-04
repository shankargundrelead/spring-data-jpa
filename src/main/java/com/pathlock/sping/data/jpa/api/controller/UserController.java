package com.pathlock.sping.data.jpa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pathlock.sping.data.jpa.api.model.User;
import com.pathlock.sping.data.jpa.api.service.UserService;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}

	@GetMapping("/getUserByProfession/{profession}")
	public List<User> findAllProfession(@PathVariable String profession){
		return userService.findByProfession(profession);
	}
	
	@GetMapping("/getAgeCount/{age}")
	public String countByAge(@PathVariable int age) {
		return " age count is for "+age+" is : " +userService.countByAge(age);
	}
	
	@DeleteMapping("/deleteByName/{name}")
	public List<User> deleteByName(@PathVariable String name){
		return userService.deleteByName(name);
	}
	
	@GetMapping("/getUserByProfessionAndAge/{profession}/{age}")
	public List<User> getByProfessionAndAge(@PathVariable String profession, @PathVariable int age){
		return	userService.findByProfessionAndAge(profession, age);
		}
	
	@GetMapping("/getUserByProfessionIgnoreCase/{profession}")
	public List<User> getByProfessionIgnoreCase(String profession){
		return userService.findByProfessionIgnoreCase(profession);
	}
	
//	@GetMapping("/getUserByPagination")
//	public Page<User> getPagination(@RequestParam int page , @RequestParam int size){
//		return	userService.getPagination(page, size);
	//	}
	
	@GetMapping("/getUserByPagination")
	public Page<User> getPagination(Pageable pageable){
		return	userService.getPagination(pageable);
		}
	
	@GetMapping("/getUserFromCustomQuery/")
	public List<User> getUserFromCustomQuery(){
		return userService.getUserFromCustomQuery();
	}
}
