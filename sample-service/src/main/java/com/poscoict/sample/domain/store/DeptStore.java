package com.poscoict.sample.domain.store;

import java.util.List;

import com.poscoict.sample.domain.entity.Dept;

public interface DeptStore {
	void create(Dept dept);

	List<Dept> retrieveAll();
	
	Dept retrieve(int deptno);

	void update(Dept dept);

	void delete(int deptno);
}
