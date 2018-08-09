package com.poscoict.sample.ra.store.jpa.jpo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.poscoict.sample.domain.entity.Emp;

@Entity(name = "Emp")
@Table(name = "EMP")
public class EmpJpo {
	@Id
	private int empno;
	private String ename;
	private String job;
	private int manager;
	private int salary;
	private int deptno;

	@SuppressWarnings("unused")
	private EmpJpo() {
	}

	public EmpJpo(Emp emp) {
		BeanUtils.copyProperties(emp, this);
	}

	public void update(Emp emp) {
		BeanUtils.copyProperties(emp, this);
	}

	public Emp toDomain() {
		Emp emp = new Emp();
		BeanUtils.copyProperties(this, emp);
		return emp;
	}

	public static List<Emp> toDomains(Iterable<EmpJpo> empJpos) {
		return StreamSupport.stream(empJpos.spliterator(), false).map(EmpJpo::toDomain).collect(Collectors.toList());
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
