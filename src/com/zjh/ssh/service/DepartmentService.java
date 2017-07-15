package com.zjh.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjh.ssh.dao.DepartmentDao;
import com.zjh.ssh.entities.Department;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	public List<Department> getAll() {
		return departmentDao.getAll();
	}

	public List<Department> getAllByPage(int pageNum) {
		return departmentDao.getAllByPage(pageNum);
	}

	public int getMaxPage() {
		return departmentDao.getMaxPage();
	}

	public Department get(Integer deptno) {
		return departmentDao.get(deptno);
	}

	public void saveOrUpdate(Department dept) {
		departmentDao.saveOrUpdate(dept);
	}

	public void delete(Integer deptno) {
		departmentDao.delete(deptno);
	}
}
