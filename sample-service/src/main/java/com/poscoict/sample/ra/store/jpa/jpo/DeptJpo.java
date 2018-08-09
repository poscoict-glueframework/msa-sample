package com.poscoict.sample.ra.store.jpa.jpo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.poscoict.sample.domain.entity.Dept;

@Entity(name = "Dept")
@Table(name = "DEPT")
public class DeptJpo {

	@Id
	private int deptno;
	private String dname;
	private String loc;

	@SuppressWarnings("unused")
	private DeptJpo() {
	}

	public DeptJpo(Dept dept) {
		// TODO Auto-generated constructor stub
		BeanUtils.copyProperties(dept, this);
	}

	public void update(Dept dept) {
		BeanUtils.copyProperties(dept, this);
	}

	public Dept toDomain() {
		Dept dept = new Dept();
		BeanUtils.copyProperties(this, dept);
		return dept;
	}

	public static List<Dept> toDomains(Iterable<DeptJpo> deptJpos) {
		return StreamSupport.stream(deptJpos.spliterator(), false).map(DeptJpo::toDomain).collect(Collectors.toList());
	}

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
}
