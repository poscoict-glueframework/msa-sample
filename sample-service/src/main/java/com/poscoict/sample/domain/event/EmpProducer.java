package com.poscoict.sample.domain.event;

import java.util.List;

import com.poscoict.sample.domain.entity.Dept;
import com.poscoict.sample.domain.entity.Emp;

public interface EmpProducer {

	void disuseEmp(int empno);

	void disuseDept(int deptno);

	void registerEmp(Emp emp);

	void registerDept(Dept dept, List<Emp> empList);
}
