package com.poscoict.sample.domain.store;

import java.util.List;

import com.poscoict.sample.domain.entity.SampleEntity;

public interface SampleStore {
	void create(SampleEntity entity);

	void update(SampleEntity entity);

	void delete(String id);

	SampleEntity retrieve(String condition);

	List<SampleEntity> retrieveAll();
}