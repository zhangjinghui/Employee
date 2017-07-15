package com.zjh.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zjh.ssh.entities.Employee;
import com.zjh.ssh.entities.User;

@Repository
public class EmployeeDao extends BaseDao {

	public Integer getMaxPage() {
		String hql = "SELECT COUNT(*) FROM Employee";
		return (int) (Math.ceil(Integer.parseInt(getSession().createQuery(hql)
				.uniqueResult().toString()) / 5.0));
	}

	public List<Employee> getAll(int pageNum) {
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).setFirstResult((pageNum - 1) * 5)
				.setMaxResults(5).list();
	}

	public void delete(Integer id) {
		Employee employee = (Employee) getSession().get(Employee.class, id);
		getSession().delete(employee);
	}

	public boolean saveOrUpdate(Employee employee) {
		boolean flag = false;
		if (employee.getJob().equals("部长")) {
			String hql = "FROM Employee e WHERE e.job = ? and e.department.deptno = ?";
			List list = getSession().createQuery(hql).setString(0, "部长")
					.setInteger(1, employee.getDepartment().getDeptno()).list();
			if (list != null) {
				return flag;
			}
		}
		getSession().saveOrUpdate(employee);
		return true;
	}

	public User getEmployeeByLastName(String lastName) {
		String hql = "FROM User u WHERE u.username = ?";
		Query query = getSession().createQuery(hql).setString(0, lastName);
		return (User) query.uniqueResult();
	}

	public Employee get(Integer id) {
		return (Employee) getSession().get(Employee.class, id);
	}

	public List<Employee> getEmpByDept(Integer deptno, int pageNum) {
		String hql = "FROM Employee e WHERE e.department.deptno = ?";
		return getSession().createQuery(hql).setInteger(0, deptno)
				.setFirstResult((pageNum - 1) * 5).setMaxResults(5).list();
	}

	public int getEmpByDeptMaxPage(int deptno) {
		String hql = "SELECT COUNT(*) FROM Employee e WHERE e.department.deptno = ?";
		return (int) Math.ceil(Integer.parseInt(getSession().createQuery(hql)
				.setInteger(0, deptno).uniqueResult().toString()) / 5.0);
	}

}
