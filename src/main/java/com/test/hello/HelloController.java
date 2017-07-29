package com.test.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public User hello(User user) {
		try{
			System.out.println("enter hello method");
			return user;
		} catch(Exception e) {
			System.out.println("exception");
		} finally {
			System.out.println("finally");
		}
		return user;
	}

}

class User {
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
