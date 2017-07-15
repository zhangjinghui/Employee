package com.zjh.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjh.ssh.dao.SalGradeDao;
import com.zjh.ssh.entities.SalGrade;

@Service
public class SalGradeService {
	@Autowired
	private SalGradeDao salGradeDao;

	public Integer getMaxPage() {
		return salGradeDao.getMaxPage();
	}

	public List<SalGrade> getAll(int pageNum) {
		return salGradeDao.getAll(pageNum);
	}

	public void delete(Integer id) {
		salGradeDao.delete(id);
	}

	public void saveOrUpdate(SalGrade salGrade) {
		salGradeDao.saveOrUpdate(salGrade);
	}

	public SalGrade get(Integer id) {
		return salGradeDao.get(id);
	}

	public SalGrade get(String job) {
		return salGradeDao.get(job);
	}

	public List<String> getJobs() {
		return salGradeDao.getJobs();
	}

}
