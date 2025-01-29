package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.CarDao;
import com.tka.entity.Car;
@Service
public class CarService {
	@Autowired
	CarDao dao;
	public String insertData(Car c) {
		String msg=dao.insertData(c);
		return msg;
	}
	
	public String updateData(Car c,int id) {
		String msg=dao.updateData(c, id);
		return msg;
	}
	
	public String deleteData(Car c,int id) {
		String msg=dao.deleteData(c, id);
		return msg;
		
	}
	public Car getOneRec(int id) {
		Car msg=dao.getOneRec(id);
		return msg;
	}
	
	public List<Car> fetchAll(){
		List<Car>list=dao.fetchAll();
		return list;
	}

}
