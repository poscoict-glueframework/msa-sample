package com.poscoict.sample.domain.entity;

import java.io.Serializable;

import com.google.gson.Gson;
import com.poscoict.sample.domain.JsonSerializable;

public class Dept implements Serializable, JsonSerializable {
	private static final long serialVersionUID = 1L;
	private int deptno;
	private String dname;
	private String loc;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public static Dept fromJson(String json) {
		return new Gson().fromJson(json, Dept.class);
	}

	public static Dept getSample() {
		Dept dept = new Dept();
		dept.setDeptno(10);
		return dept;
	}
}
