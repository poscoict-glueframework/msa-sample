package com.poscoict.sample.domain.logic;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.sample.domain.entity.Dept;
import com.poscoict.sample.domain.entity.Emp;
import com.poscoict.sample.domain.entity.SampleEntity;
import com.poscoict.sample.domain.proxy.SampleProxy;
import com.poscoict.sample.domain.proxy.sdo.SampleRdo;
import com.poscoict.sample.domain.spec.SampleService;
import com.poscoict.sample.domain.spec.sdo.DeptCdo;
import com.poscoict.sample.domain.spec.sdo.EmpCdo;
import com.poscoict.sample.domain.spec.sdo.SampleEntityCdo;
import com.poscoict.sample.domain.store.DeptStore;
import com.poscoict.sample.domain.store.EmpStore;
import com.poscoict.sample.domain.store.SampleStore;

@Service
public class SampleLogic implements SampleService {
	@Autowired
	private SampleStore store;

	// List list = new ArrayList();
	public List<SampleEntity> findAll() {
		return store.retrieveAll();
	}

	public void registerData(SampleEntityCdo cdo) {
		SampleEntity entity = store.retrieve(cdo.getCondition());
		if (entity != null) {
			entity.setAttr1(cdo.getAttr1());
			entity.setAttr2(cdo.getAttr2());
			store.update(entity);
		} else {
			store.create(SampleEntity.fromJson(cdo.toJson()));
		}
	}

	public void modifyData(String condition, SampleEntityCdo cdo) {
		SampleEntity entity = store.retrieve(condition);
		entity.setAttr1(cdo.getAttr1());
		entity.setAttr2(cdo.getAttr2());
		store.update(entity);
	}

	public void removeData(String condition) {
		store.delete(store.retrieve(condition).getId());
	}

	// 추가
	@Autowired
	private EmpStore empStore;
	@Autowired
	private DeptStore deptStore;

	@Override
	public List<Dept> getDeptList() {
		return deptStore.retrieveAll();
	}

	@Override
	public Dept findDept(int deptno) {
		return deptStore.retrieve(deptno);
	}

	@Override
	public void registerDept(DeptCdo cdo) {
		deptStore.create(Dept.fromJson(cdo.toJson()));
	}

	@Override
	public void registerEmp(EmpCdo cdo) {
		empStore.create(Emp.fromJson(cdo.toJson()));
	}

	@Override
	public void modifyDept(String no, String name, String loc) {
		Dept dept = new Dept();
		dept.setDeptno(Integer.parseInt(no));
		dept.setDname(name);
		dept.setLoc(loc);
		deptStore.update(dept);
	}

	@Override
	public void modifyEmp(String no, EmpCdo cdo) {
		Emp emp = Emp.fromJson(cdo.toJson());
		emp.setEmpno(Integer.parseInt(no));
		empStore.update(emp);
	}

	@Override
	public void removeEmpInDept(String deptno) {
		List<Emp> values = empStore.retrieveByDeptno(Integer.parseInt(deptno));
		for (Emp emp : values) {
			empStore.delete(emp.getEmpno());
		}
	}

	@Override
	public List<Emp> findEmpListByDeptno(String deptno) {
		return empStore.retrieveByDeptno(Integer.parseInt(deptno));
	}

	@Override
	public Emp findEmp(int empno) {
		return empStore.retreive(empno);
	}

	@PostConstruct
	private void init() {
		Dept dept = Dept.getSample();
		deptStore.create(dept);
		Emp emp = Emp.getSample();
		empStore.create(emp);
	}

	@Autowired
	private SampleProxy proxy;

	@Override
	public List<SampleEntity> findSome(String name) {
		// TODO Auto-generated method stub
		SampleRdo rdo = proxy.findData(name);
		if (rdo == null) {
			return null;
		}

		String condition = rdo.getName();
		List<SampleEntity> list = new ArrayList<>();
		list.add(store.retrieve(condition));
		SampleEntity newEntity = new SampleEntity();
		newEntity.setCondition(name + " copy");
		newEntity.setAttr1(rdo.getName());
		newEntity.setAttr2(rdo.getValue());
		list.add(newEntity);
		return list;
	}
}
