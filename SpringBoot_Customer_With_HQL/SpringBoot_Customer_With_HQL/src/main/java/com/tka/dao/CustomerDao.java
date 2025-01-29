package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Customer;

@Repository
public class CustomerDao {
	@Autowired
	SessionFactory sf;

	public String insertData(Customer c) {
		Session ss = null;
		Transaction tr = null;
		String msg = null;
		try {
			ss = sf.openSession();
			tr = ss.beginTransaction();
			String hql = "insert into Customer(id,name,address,mobileNo)values(:id,:name,:address,:mobileNo)";
			MutationQuery mq = ss.createMutationQuery(hql);
			mq.setParameter("id", c.getId());
			mq.setParameter("name", c.getName());
			mq.setParameter("address", c.getAddress());
			mq.setParameter("mobileNo", c.getMobileNo());
			mq.executeUpdate();
			tr.commit();
			msg = "Data is inserted....!";
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();

		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return msg;
	}

	public String deleteData(int id) {
		Session ss = null;
		Transaction tr = null;
		String msg = null;
		try {
			ss = sf.openSession();
			tr = ss.beginTransaction();

			String hql = "delete from Customer where id=:id";
			MutationQuery mq = ss.createMutationQuery(hql);
			mq.setParameter("id", id);
			mq.executeUpdate();
			tr.commit();
			msg = "Customer data is deleted successfully...!";
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return msg;

	}

	public String updateData(Customer c, int id) {
		Session ss = null;
		Transaction tr = null;
		String msg = null;

		try {
			ss = sf.openSession();
			tr = ss.beginTransaction();

			String hql = "update Customer set name=:name,address=:address,mobileNo=:mobileNo where id=:id";
			MutationQuery mq = ss.createMutationQuery(hql);
			mq.setParameter("id", id);
			mq.setParameter("name", c.getName());
			mq.setParameter("address", c.getAddress());
			mq.setParameter("mobileNo", c.getMobileNo());
			mq.executeUpdate();
			tr.commit();
			msg = "Customer is Updated...!";
		} catch (Exception e) {
			if (tr != null) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	public Customer GetOneRec(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hql = "from Customer where id=:id";
		Query<Customer> query = ss.createQuery(hql, Customer.class);
		query.setParameter("id", id);
		Customer result = query.getSingleResult();
		tr.commit();
		return result;

	}
	public List<Customer> FetchAll() {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		String hql ="from Customer";
		Query<Customer> query=ss.createQuery(hql);
		List<Customer>list= query.list();
		return list;
	}
}
