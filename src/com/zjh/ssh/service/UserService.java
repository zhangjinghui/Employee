package com.zjh.ssh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjh.ssh.dao.UserDao;
import com.zjh.ssh.entities.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public User login(User user) {
		return userDao.login(user);
	}

	public User get(Integer id) {
		return userDao.get(id);
	}

	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}
}
