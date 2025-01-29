package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Job;

@Repository
public class JobDao {

	@Autowired
	SessionFactory sf;

	public String insertData(Job j) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlquery = "insert into Job(j_role,experience,salaryPackage,qualification,passYear)values(:j_role,:experience,:salaryPackage,:qualification,:passYear)";
		MutationQuery query = ss.createMutationQuery(hqlquery);
		query.setParameter("j_role", j.getJ_role());
		query.setParameter("experience", j.getExperience());
		query.setParameter("salaryPackage", j.getSalaryPackage());
		query.setParameter("qualification", j.getQualification());
		query.setParameter("passYear", j.getPassYear());
		query.executeUpdate();

		tr.commit();
		ss.close();

		return "data is inserted...!";

	}

	public String deleteData(Job j, int id) {

		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlquery = "delete from Job where id=:id";
		MutationQuery mq = ss.createMutationQuery(hqlquery);

		mq.setParameter("id", j.getId());
		mq.executeUpdate();
		tr.commit();
		ss.close();
		return "Data is deleted...!";

	}

	public Job getOneRec(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hql = "from Job where id=:id";
		Query<Job> query = ss.createQuery(hql, Job.class);
		query.setParameter("id", id);
		Job result = query.getSingleResult();
		tr.commit();
		ss.close();
		return result ;
	}

	public List<Job> getAllRec() {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlquery = "from Job";
		Query<Job> query = ss.createQuery(hqlquery);
		List<Job> list = query.list();
		return list;
	}
	
	public String updatedata(Job j,int id) {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		String hqlquery="update Job set j_role=:j_role,experience=:experience,salaryPackage=:salaryPackage,qualification=:qualification,passYear=:passYear where id=:id";
		MutationQuery query= ss.createMutationQuery(hqlquery);
		query.setParameter("id",id);
		query.setParameter("j_role",j.getJ_role());
		query.setParameter("experience", j.getExperience());
		query.setParameter("salaryPackage", j.getSalaryPackage());
		query.setParameter("qualification", j.getQualification());
		query.setParameter("passYear", j.getPassYear());
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "data updated...!";
	}

	

}
