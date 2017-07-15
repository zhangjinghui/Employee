package com.zjh.ssh.dao;



import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zjh.ssh.entities.Task;



@Repository
public class TaskDao extends BaseDao{
	
	
	public List<Task> getAll(int pageNum) {
		String hql = "FROM Task";
		return getSession().createQuery(hql).setFirstResult((pageNum - 1) * 5)
				.setMaxResults(5).list();
	}

	public Integer getMaxPage() {
		String hql = "SELECT COUNT(*) FROM Task";
		return (int) (Math.ceil(Integer.parseInt(getSession().createQuery(hql)
				.uniqueResult().toString()) / 5.0));
	}

	public void delete(Integer id) {
		Task task = (Task) getSession().get(Task.class, id);
		getSession().delete(task);
	}
	
	
	public void saveOrUpdate(Task task) {
		getSession().saveOrUpdate(task);
	}
	

	public Task get(Integer id) {
		return (Task) getSession().get(Task.class, id);
	}
}
