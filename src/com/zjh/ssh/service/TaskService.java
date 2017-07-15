package com.zjh.ssh.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjh.ssh.dao.TaskDao;


import com.zjh.ssh.entities.Task;


@Service
public class TaskService {

	
	@Autowired
	private TaskDao taskDao;
	
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
	
	public List<Task> getAll(int pageNum) {
		return taskDao.getAll(pageNum);
	}

	public Integer getMaxPage() {
		return taskDao.getMaxPage();
	}

	public void delete(Integer id) {
		taskDao.delete(id);
	}

	public void saveOrUpdate(Task task) {
		taskDao.saveOrUpdate(task);
		
	}

	public Task get(Integer id) {
		return taskDao.get(id);
	}
	
	
	
	
	
	
	
	
}
