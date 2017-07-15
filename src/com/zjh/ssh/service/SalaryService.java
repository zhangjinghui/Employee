package com.zjh.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjh.ssh.dao.SalaryDao;
import com.zjh.ssh.entities.Salary;

@Service
public class SalaryService {
	@Autowired
	private SalaryDao salaryDao;

	public Integer getMaxPage() {
		return salaryDao.getMaxPage();
	}

	public List<Salary> getAll(int pageNum) {
		return salaryDao.getAll(pageNum);
	}

	public void saveOrUpdate(Salary salary) {
		salaryDao.saveOrUpdate(salary);
	}

}
