package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Customer;
import com.tka.service.CustomerService;
@RestController
public class CustomerController {
	@Autowired
	CustomerService service;
	@PostMapping("/submit")
	public String insertData(@RequestBody Customer c) {
		String msg=service.insertData(c);
		return msg;
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=service.deleteData(id);
		return msg;
	}
	
	@PutMapping("/update/{id}")
	public String updateData(@RequestBody Customer c,@PathVariable int id) {
		String msg=service.updateData(c, id);
		return msg;
	}
	@GetMapping("/getone")
	public Customer GetOneRec(@RequestParam int id) {
		Customer msg=service.GetOneRec(id);
		return msg;
	}
	@GetMapping("/fetchAll")
	public List<Customer> FetchAll() {
		List<Customer>msg=service.FetchAll();
		return msg;
	}

}
