package com.poscoict.sample.ra.store.jpa;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.sample.domain.entity.SampleEntity;
import com.poscoict.sample.domain.store.SampleStore;
import com.poscoict.sample.ra.store.jpa.jpo.SampleJpo;
import com.poscoict.sample.ra.store.jpa.repository.SampleRepository;

@Repository
public class SampleJpaStore implements SampleStore {
	@Autowired
	private SampleRepository repository;

	public void create(SampleEntity entity) {
		repository.save(new SampleJpo(entity));
	}

	public void update(SampleEntity entity) {
		repository.save(new SampleJpo(entity));
	}

	public void delete(String id) {
		repository.deleteById(id);
	}

	public SampleEntity retrieve(String condition) {
		SampleJpo value = repository.findByCondition(condition);
		if (value == null) {
			return null;
		}
		return value.toDomain();
	}

	public List<SampleEntity> retrieveAll() {
		return SampleJpo.toDomains(repository.findAll());
	}

	@PostConstruct
	public void init() {
		SampleEntity entity = new SampleEntity();
		entity.setCondition("1st");
		entity.setAttr1("init attr1");
		entity.setAttr2("init attr2");
		repository.save(new SampleJpo(entity));
		entity = new SampleEntity();
		entity.setCondition("2nd");
		entity.setAttr1("init attr1");
		entity.setAttr2("init attr2");
		repository.save(new SampleJpo(entity));
	}
}
