package com.poscoict.sample.ra.store.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.poscoict.sample.ra.store.jpa.jpo.DeptJpo;

public interface DeptRepository extends PagingAndSortingRepository<DeptJpo, Integer>{

}
