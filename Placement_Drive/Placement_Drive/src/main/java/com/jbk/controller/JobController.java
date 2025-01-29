package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Job;
import com.jbk.service.JobService;
@RestController

public class JobController {
	@Autowired
	JobService service;
	@PostMapping("/save")
	public String insertData(@RequestBody Job j) {
		String msg=service.insertData(j);
		return msg;
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteData(Job j ,@PathVariable int id) {
		String msg=service.deleteData(j,id);
		return msg;
	}
	
	@GetMapping("/get")
	public Job getOneRec(@RequestParam int id) {
		Job msg=service.getOneRec(id);
		return msg;
		
	}
	
	@GetMapping("/getAllRec")
	public List<Job> getAllRec() {
		List<Job>list= service.getAllRec();
		return list;
	}
	
	@PutMapping("updatedata/{id}")
	public String updatedata(@RequestBody Job j,@PathVariable int id) {
		String msg=service.updatedata(j,id);
		return msg;
	}
	
	
     
	
}
