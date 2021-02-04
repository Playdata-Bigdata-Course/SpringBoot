package io.playdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.playdata.model.domain.Customer;

@RestController
public class Controller {
	@GetMapping("/")
	public String m1() {
		System.out.println("m1()실행됐다");
		return "hello world";
	}

	// http://localhost/param?id=data
	@GetMapping("/param")
	public String m2(@RequestParam String id) {
		System.out.println("m2()실행" + id);
		return "hello world" + id;
	}

	@PostMapping("/customer")
	public Customer m3(Customer c) {
		System.out.println("m3 : " + c);
		return c;
	}
	
	 @GetMapping("/validate")
	   public Customer m5() {
	      return new Customer("kom", 27);
	   }

}
