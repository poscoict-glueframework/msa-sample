package com.poscoict.sample.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.sample.domain.entity.Dept;
import com.poscoict.sample.domain.entity.Emp;
import com.poscoict.sample.domain.entity.SampleEntity;
import com.poscoict.sample.domain.logic.SampleLogic;
import com.poscoict.sample.domain.spec.SampleService;
import com.poscoict.sample.domain.spec.sdo.DeptCdo;
import com.poscoict.sample.domain.spec.sdo.EmpCdo;
import com.poscoict.sample.domain.spec.sdo.SampleEntityCdo;

@RestController
@RequestMapping("sample")
public class SampleResource implements SampleService {
	@Autowired
	private SampleLogic logic;

	@Override
	@GetMapping
	public List<SampleEntity> findAll() {
		return logic.findAll();
	}

	@Override
	@PostMapping
	public void registerData(@RequestBody SampleEntityCdo cdo) {
		logic.registerData(cdo);
	}

	@Override
	@PutMapping("{entityId}")
	public void modifyData(@PathVariable String entityId, @RequestBody SampleEntityCdo cdo) {
		logic.modifyData(entityId, cdo);
	}

	@Override
	@DeleteMapping("{entityId}")
	public void removeData(@PathVariable String entityId) {
		logic.removeData(entityId);
	}

	// 추가
	@GetMapping("depts")
	@Override
	public List<Dept> getDeptList() {
		return logic.getDeptList();
	}

	@GetMapping(path = "dept", params = { "deptno" })
	@Override
	public Dept findDept(@RequestParam int deptno) {
		return logic.findDept(deptno);
	}

	@PostMapping("dept")
	@Override
	public void registerDept(@RequestBody DeptCdo cdo) {
		logic.registerDept(cdo);
	}

	@PostMapping("emp")
	@Override
	public void registerEmp(@RequestBody EmpCdo cdo) {
		logic.registerEmp(cdo);
	}

	@PutMapping(path = "dept/{deptno}", params = { "name", "loc" })
	@Override
	public void modifyDept(@PathVariable String deptno, @RequestParam String name, @RequestParam String loc) {
		logic.modifyDept(deptno, name, loc);
	}

	@PutMapping(path = "emp/{empno}")
	@Override
	public void modifyEmp(@PathVariable String empno, @RequestBody EmpCdo cdo) {
		logic.modifyEmp(empno, cdo);
	}

	@DeleteMapping(path = "emp", params = { "deptno" })
	@Override
	public void removeEmpInDept(@RequestParam String deptno) {
		logic.removeEmpInDept(deptno);
	}

	@GetMapping(path = "emp", params = { "deptno" })
	@Override
	public List<Emp> findEmpListByDeptno(@RequestParam String deptno) {
		return logic.findEmpListByDeptno(deptno);
	}

	@GetMapping("emps")
	@Override
	public Emp findEmp(int empno) {
		return logic.findEmp(empno);
	}

	@GetMapping("proxy")
	@Override
	public List<SampleEntity> findSome(@RequestParam String name) {
		return logic.findSome(name);
	}
}