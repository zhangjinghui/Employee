package com.zjh.ssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjh.ssh.entities.Customer;

@Repository
public class CustomerDao extends BaseDao {
	public List<Customer> getAll(int pageNum) {
		String hql = "FROM Customer";
		return getSession().createQuery(hql).setFirstResult((pageNum - 1) * 5)
				.setMaxResults(5).list();
	}

	public Integer getMaxPage() {
		String hql = "SELECT COUNT(*) FROM Customer";
		return (int) (Math.ceil(Integer.parseInt(getSession().createQuery(hql)
				.uniqueResult().toString()) / 5.0));
	}

	public Customer get(Integer id) {
		return (Customer) getSession().get(Customer.class, id);
	}

	public void saveOrUpdate(Customer model) {
		getSession().saveOrUpdate(model);
	}

	public void delete(Integer id) {
		Customer customer = (Customer) getSession().get(Customer.class, id);
		getSession().delete(customer);
	}
}
