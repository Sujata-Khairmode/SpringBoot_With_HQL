package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Car;

@Repository
public class CarDao {
	@Autowired
	SessionFactory sf;

	public String insertData(Car c) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlQuery = "insert into Car(name,color,model,price)values(:name,:color,:model,:price)";
		MutationQuery mq = ss.createMutationQuery(hqlQuery);
		mq.setParameter("name", c.getName());
		mq.setParameter("color", c.getColor());
		mq.setParameter("model", c.getModel());
		mq.setParameter("price", c.getPrice());
		mq.executeUpdate();
		tr.commit();
		ss.close();
		return "Car data inserted successfully....!";
	}

	public String updateData(Car c, int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hql = "update Car set name=:cname,color=:ccolor,model=:cmodel,price=:cprice where id=:id";
		MutationQuery query = ss.createMutationQuery(hql);
		query.setParameter("id", id);
		query.setParameter("cname", c.getName());
		query.setParameter("ccolor", c.getColor());
		query.setParameter("cmodel", c.getModel());
		query.setParameter("cprice", c.getPrice());
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "car data is updated successfully...!";

	}

	public String deleteData(Car c, int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hql = "delete from Car where id=:id";
		MutationQuery query = ss.createMutationQuery(hql);
		query.setParameter("id", c.getId());
		query.executeUpdate();
		tr.commit();
		ss.close();
		return "Car data is deleted....!";
	}

	public Car getOneRec(int id) {
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		String hql = "from Car where id=:id";
		Query<Car> query = ss.createQuery(hql, Car.class);
		query.setParameter("id", id);
		Car result = query.getSingleResult();
		tr.commit();
		ss.close();
		return result;

	}

	public List<Car> fetchAll() {
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		String hql="from Car";
		Query<Car> query=ss.createQuery(hql);
		List<Car>list=query.list();
		return list;
	}
}
