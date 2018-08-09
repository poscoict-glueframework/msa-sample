package com.poscoict.sample.ra.store.jpa.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.poscoict.sample.ra.store.jpa.jpo.EmpJpo;

public interface EmpRepository extends PagingAndSortingRepository<EmpJpo, Integer> {
	List<EmpJpo> findByDeptno(int deptno);
}
