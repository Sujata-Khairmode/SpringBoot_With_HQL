package com.tka.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.CustomerDao;
import com.tka.entity.Customer;
@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;

	public String insertData(Customer c) {
		String msg=dao.insertData(c);
		if(Objects.isNull(msg)) {
		 msg ="Data is not inserted....!";
		}
		return msg;
	}
	
	public String deleteData(int id) {
		String msg=dao.deleteData(id);
		if(Objects.isNull(msg)) {
			msg = "This id is not exist in the database......!";
		}
		return msg;
	}
	
	public String updateData(Customer c, int id) {
		String msg=dao.updateData(c, id);
		if(Objects.isNull(msg)) {
			msg = "data is not updated....!";
		}
		return msg;
	}
	
	public Customer GetOneRec(int id) {
		Customer msg=dao.GetOneRec(id);
		return msg;
	}
	
	public List<Customer> FetchAll() {
		List<Customer> msg=dao.FetchAll();
		return msg;
	}
}
