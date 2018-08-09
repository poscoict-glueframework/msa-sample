package com.poscoict.sample.domain.spec;

import java.util.List;

import com.poscoict.sample.domain.entity.Dept;
import com.poscoict.sample.domain.entity.Emp;
import com.poscoict.sample.domain.entity.SampleEntity;
import com.poscoict.sample.domain.spec.sdo.DeptCdo;
import com.poscoict.sample.domain.spec.sdo.EmpCdo;
import com.poscoict.sample.domain.spec.sdo.SampleEntityCdo;

public interface SampleService {
	List<SampleEntity> findAll();

	void registerData(SampleEntityCdo cdo);

	void modifyData(String entityId, SampleEntityCdo cdo);

	void removeData(String entityId);

	List<SampleEntity> findSome(String name);

	// 추가
	List<Dept> getDeptList();

	Dept findDept(int deptno);

	void registerDept(DeptCdo cdo);

	void registerEmp(EmpCdo cdo);

	void modifyDept(String no, String name, String loc);

	void modifyEmp(String no, EmpCdo cdo);

	void removeEmpInDept(String deptno);

	List<Emp> findEmpListByDeptno(String deptno);

	Emp findEmp(int empno);
}