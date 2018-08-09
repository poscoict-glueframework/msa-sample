package com.poscoict.sample.ra.store.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.sample.domain.entity.Emp;
import com.poscoict.sample.domain.store.EmpStore;
import com.poscoict.sample.ra.store.jpa.jpo.EmpJpo;
import com.poscoict.sample.ra.store.jpa.repository.EmpRepository;

@Repository
public class EmpJpaStore implements EmpStore {

	@Autowired
	EmpRepository empRepository;

	@Override
	public void create(Emp emp) {
		int id = emp.getEmpno();
		if (empRepository.existsById(id)) {
			throw new RuntimeException(String.format("emp[%s] already exists", id));
		}
		empRepository.save(new EmpJpo(emp));
	}

	@Override
	public List<Emp> retrieveAll() {
		return EmpJpo.toDomains(empRepository.findAll());
	}

	@Override
	public List<Emp> retrieveByDeptno(int deptno) {
		return EmpJpo.toDomains(empRepository.findByDeptno(deptno));
	}

	@Override
	public Emp retreive(int empno) {
		if (empRepository.existsById(empno)) {
			throw new RuntimeException(String.format("No emp[%s] to retrieve", empno));
		}
		Optional<EmpJpo> value = empRepository.findById(empno);
		if (value.isPresent()) {
			EmpJpo jpo = value.get();
			return jpo.toDomain();
		}
		return null;
	}

	@Override
	public void update(Emp emp) {
		if (empRepository.existsById(emp.getEmpno())) {
			throw new RuntimeException(String.format("No emp[%s] to retrieve", emp.getEmpno()));
		}
		Optional<EmpJpo> value = empRepository.findById(emp.getEmpno());
		if (value.isPresent()) {
			EmpJpo jpo = value.get();
			jpo.update(emp);
			empRepository.save(jpo);
		}
	}

	@Override
	public void delete(int empno) {
		empRepository.deleteById(empno);
	}
}
