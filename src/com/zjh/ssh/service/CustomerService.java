package com.zjh.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjh.ssh.dao.CustomerDao;
import com.zjh.ssh.entities.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public List<Customer> getAll(int pageNum) {
		return customerDao.getAll(pageNum);
	}

	public int getMaxPage() {
		return customerDao.getMaxPage();
	}

	public Customer get(Integer id) {
		return customerDao.get(id);
	}

	public void saveOrUpdate(Customer model) {
		customerDao.saveOrUpdate(model);
	}

	public void delete(Integer id) {
		customerDao.delete(id);
	}
}
