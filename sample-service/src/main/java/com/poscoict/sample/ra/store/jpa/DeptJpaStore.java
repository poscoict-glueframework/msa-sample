package com.poscoict.sample.ra.store.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.sample.domain.entity.Dept;
import com.poscoict.sample.domain.store.DeptStore;
import com.poscoict.sample.ra.store.jpa.jpo.DeptJpo;
import com.poscoict.sample.ra.store.jpa.repository.DeptRepository;
import com.poscoict.sample.ra.store.jpa.repository.EmpRepository;

@Repository
public class DeptJpaStore implements DeptStore{

	@Autowired
	DeptRepository deptRepository;
	
	@Autowired
	EmpRepository empRepository;
	
	@Override
	public void create(Dept dept) {
		int id = dept.getDeptno();
		if (deptRepository.existsById(id)) {
			throw new RuntimeException(String.format("emp[%s] already exists", id));
		}
		deptRepository.save(new DeptJpo(dept));
		
	}

	@Override
	public List<Dept> retrieveAll() {
		return DeptJpo.toDomains(deptRepository.findAll());
	}

	@Override
	public void update(Dept dept) {
		if(deptRepository.existsById(dept.getDeptno())) {
			throw new RuntimeException(String.format("No dept[%s] to update", dept.getDeptno()));
		}
		Optional<DeptJpo> value = deptRepository.findById(dept.getDeptno());
		if (value.isPresent()) {
			DeptJpo jpo = value.get();
			jpo.update(dept);
			deptRepository.save(jpo);
		}
	}

	@Override
	public void delete(int deptno) {
		if ( empRepository.findByDeptno(deptno).size() > 0 ) {
			throw new RuntimeException(String.format("emp[%s] exist", deptno));
		}
		deptRepository.deleteById(deptno);
	}

	@Override
	public Dept retrieve(int deptno) {
		Optional<DeptJpo> value = deptRepository.findById(deptno);
		return value.get().toDomain();
	}
}
