package com.zjh.ssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjh.ssh.entities.Department;

@Repository
public class DepartmentDao extends BaseDao {
	public List<Department> getAll() {
		String hql = "FROM Department";
		return getSession().createQuery(hql).list();
	}

	public List<Department> getAllByPage(int pageNum) {
		String hql = "FROM Department";
		return getSession().createQuery(hql).setFirstResult((pageNum - 1) * 5)
				.setMaxResults(5).list();
	}

	public int getMaxPage() {
		String hql = "SELECT COUNT(*) FROM Department";
		return (int) Math.ceil(Integer.parseInt(getSession().createQuery(hql)
				.uniqueResult().toString()) / 5.0);
	}

	public Department get(Integer deptno) {
		return (Department) getSession().get(Department.class, deptno);
	}

	public void saveOrUpdate(Department dept) {
		getSession().saveOrUpdate(dept);
	}

	public void delete(Integer deptno) {
		Department department = (Department) getSession().get(Department.class,
				deptno);
		getSession().delete(department);
	}
}
