package com.zjh.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjh.ssh.dao.EmployeeDao;
import com.zjh.ssh.dao.UserDao;
import com.zjh.ssh.entities.Employee;
import com.zjh.ssh.entities.User;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private UserDao userDao;

	public Integer getMaxPage() {
		return employeeDao.getMaxPage();
	}

	public List<Employee> getAll(int pageNum) {
		return employeeDao.getAll(pageNum);
	}

	public void delete(Integer id) {
		employeeDao.delete(id);
	}

	public void saveOrUpdate(User user, Employee employee) {
		if (employeeDao.saveOrUpdate(employee)) {
			userDao.saveOrUpdate(user);
		}
	}

	public boolean lastNameIsValid(String lastName) {
		boolean flag = employeeDao.getEmployeeByLastName(lastName) == null;
		return flag;
	}

	public Employee get(Integer id) {
		return employeeDao.get(id);
	}

	public List<Employee> getEmpByDept(Integer deptno, int pageNum) {
		return employeeDao.getEmpByDept(deptno, pageNum);
	}

	public int getEmpByDeptMaxPage(Integer deptno) {
		return employeeDao.getEmpByDeptMaxPage(deptno);
	}

}
