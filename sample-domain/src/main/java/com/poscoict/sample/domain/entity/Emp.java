package com.poscoict.sample.domain.entity;

import java.io.Serializable;

import com.google.gson.Gson;
import com.poscoict.sample.domain.JsonSerializable;

public class Emp implements Serializable, JsonSerializable {
	private static final long serialVersionUID = 1L;
	private int empno;
	private String ename;
	private String job;
	private int manager;
	private int salary;
	private int deptno;

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

	public static Emp fromJson(String json) {
		return new Gson().fromJson(json, Emp.class);
	}

	public static Emp getSample() {
		Emp emp = new Emp();
		emp.setEmpno(262892);
		emp.setDeptno(10);
		return emp;
	}
}