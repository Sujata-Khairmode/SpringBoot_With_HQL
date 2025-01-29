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

import com.tka.entity.Car;
import com.tka.service.CarService;
@RestController
public class CarController {
	@Autowired
	CarService service;
	@PostMapping("/submit")
	public String insertData(@RequestBody Car c) {
		String msg=service.insertData(c);
		return msg;
	}
	@PutMapping("/update/{id}")
	public String updateData(@RequestBody Car c,@PathVariable int id) {
		String msg=service.updateData(c, id);
		return msg;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteData(Car c,@PathVariable int id) {
		String msg=service.deleteData(c, id);
		return msg;
		
	}
	@GetMapping("get")
	public Car getOneRec(@RequestParam int id) {
		Car msg=service.getOneRec(id);
		return msg;
		
	}
	@GetMapping("fetchAll")
	public List<Car> fetchAll() {
		List<Car> list=service.fetchAll();
		return list;
	}

}
