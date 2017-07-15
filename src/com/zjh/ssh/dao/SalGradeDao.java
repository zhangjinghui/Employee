package com.zjh.ssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjh.ssh.entities.SalGrade;

@Repository
public class SalGradeDao extends BaseDao {

	public Integer getMaxPage() {
		String hql = "SELECT COUNT(*) FROM SalGrade";
		return (int) (Math.ceil(Integer.parseInt(getSession().createQuery(hql)
				.uniqueResult().toString()) / 5.0));
	}

	public List<SalGrade> getAll(int pageNum) {
		String hql = "FROM SalGrade";
		return getSession().createQuery(hql).setFirstResult((pageNum - 1) * 5)
				.setMaxResults(5).list();
	}

	public void delete(Integer id) {
		SalGrade salGrade = (SalGrade) getSession().get(SalGrade.class, id);
		String job = salGrade.getJob();
		getSession().delete(salGrade);
		getSession().createQuery("DELETE FROM Employee e WHERE e.job = ?")
				.setString(0, job).executeUpdate();
	}

	public void saveOrUpdate(SalGrade salGrade) {
		getSession().saveOrUpdate(salGrade);
	}

	public SalGrade get(Integer id) {
		return (SalGrade) getSession().get(SalGrade.class, id);
	}

	public SalGrade get(String job) {
		String hql = "FROM SalGrade s WHERE s.job = ?";
		return (SalGrade) getSession().createQuery(hql).setString(0, job)
				.uniqueResult();
	}

	public List<String> getJobs() {
		String hql = "SELECT DISTINCT s.job FROM SalGrade s";
		return getSession().createQuery(hql).list();
	}

}
