package com.zjh.ssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjh.ssh.entities.Salary;

@Repository
public class SalaryDao extends BaseDao {

	public Integer getMaxPage() {
		String hql = "SELECT COUNT(*) FROM Salary";
		return (int) (Math.ceil(Integer.parseInt(getSession().createQuery(hql)
				.uniqueResult().toString()) / 5.0));
	}

	public List<Salary> getAll(int pageNum) {
		String hql = "FROM Salary";
		return getSession().createQuery(hql).setFirstResult((pageNum - 1) * 5)
				.setMaxResults(5).list();
	}

	public void saveOrUpdate(Salary salary) {
		getSession().saveOrUpdate(salary);
	}

}
