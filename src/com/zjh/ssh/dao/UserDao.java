package com.zjh.ssh.dao;

import org.springframework.stereotype.Repository;

import com.zjh.ssh.entities.User;

@Repository
public class UserDao extends BaseDao {
	public User login(User user) {
		return (User) getSession()
				.createQuery("FROM User u WHERE u.username=? and u.password=?")
				.setString(0, user.getUsername())
				.setString(1, user.getPassword()).uniqueResult();
	}

	public User get(Integer id) {
		return (User) getSession().createQuery("FROM User u WHERE u.id=?")
				.setInteger(0, id).uniqueResult();
	}

	public void saveOrUpdate(User user) {
		getSession().saveOrUpdate(user);
	}

}
