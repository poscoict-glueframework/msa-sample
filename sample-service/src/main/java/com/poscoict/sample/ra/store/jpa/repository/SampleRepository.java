package com.poscoict.sample.ra.store.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.poscoict.sample.ra.store.jpa.jpo.SampleJpo;

public interface SampleRepository extends PagingAndSortingRepository<SampleJpo, String> {
	SampleJpo findByCondition(String codition);
}
