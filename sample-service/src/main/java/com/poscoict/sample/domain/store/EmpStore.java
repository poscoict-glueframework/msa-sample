package com.poscoict.sample.domain.store;

import java.util.List;

import com.poscoict.sample.domain.entity.Emp;

public interface EmpStore {
	void create(Emp emp);

	List<Emp> retrieveAll();

	List<Emp> retrieveByDeptno(int deptno);

	Emp retreive(int empno);

	void update(Emp emp);

	void delete(int empno);

}
