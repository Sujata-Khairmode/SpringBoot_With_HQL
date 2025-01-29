package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.JobDao;
import com.jbk.entity.Job;
@Service
public class JobService {
	@Autowired
	JobDao dao;
	public String insertData(Job j) {
		String msg=dao.insertData(j);
		return msg;
	}
	
	public String deleteData( Job j,int id) {
		String msg=dao.deleteData(j,id);
		return msg;
	}
	
	public Job getOneRec(int id) {
		Job msg=dao.getOneRec(id);
		return msg;
		
	}
	
	public List<Job> getAllRec() {
	List<Job>list=dao.getAllRec();
	return list;
	}
	
	public String updatedata(Job j,int id) {
		String msg=dao.updatedata(j,id);
		return msg;
	}
	
	

}
