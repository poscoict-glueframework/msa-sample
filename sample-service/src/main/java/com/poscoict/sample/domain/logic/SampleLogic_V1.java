package com.poscoict.sample.domain.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poscoict.sample.domain.entity.Dept;
import com.poscoict.sample.domain.entity.Emp;
import com.poscoict.sample.domain.entity.SampleEntity;
import com.poscoict.sample.domain.spec.SampleService;
import com.poscoict.sample.domain.spec.sdo.DeptCdo;
import com.poscoict.sample.domain.spec.sdo.EmpCdo;
import com.poscoict.sample.domain.spec.sdo.SampleEntityCdo;

@Service
public class SampleLogic_V1 implements SampleService {
	List<SampleEntity> list = new ArrayList<>();

	@Override
	public List<SampleEntity> findAll() {
		return list;
	}

	@Override
	public void registerData(SampleEntityCdo cdo) {
		list.add(SampleEntity.fromJson(cdo.toJson()));

	}

	@Override
	public void modifyData(String entityId, SampleEntityCdo cdo) {
		for (SampleEntity entity : list) {
			if (entityId.equals(entity.getCondition())) {
				entity.setAttr1(cdo.getAttr1());
				entity.setAttr2(cdo.getAttr2());
			}
		}
	}

	@Override
	public void removeData(String entityId) {
		for (SampleEntity entity : list) {
			if (entityId.equals(entity.getCondition())) {
				list.remove(entity);
			}
		}
	}

	// 추가
	@Override
	public List<Dept> getDeptList() {
		return null;
	}

	@Override
	public Dept findDept(int deptno) {
		return null;
	}

	@Override
	public void registerDept(DeptCdo cdo) {
	}

	@Override
	public void registerEmp(EmpCdo cdo) {
	}

	@Override
	public void modifyDept(String no, String name, String loc) {
	}

	@Override
	public void modifyEmp(String no, EmpCdo cdo) {
	}

	@Override
	public void removeEmpInDept(String deptno) {
	}

	@Override
	public List<Emp> findEmpListByDeptno(String deptno) {
		return null;
	}

	@Override
	public Emp findEmp(int empno) {
		return null;
	}

	@Override
	public List<SampleEntity> findSome(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
