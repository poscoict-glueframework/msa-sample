package com.poscoict.sample.ra.store.jpa.jpo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.poscoict.sample.domain.entity.SampleEntity;

@Entity(name = "sample")
@Table(name = "TB_SAMPLE")
public class SampleJpo {
	@Id
	private String id;
	private String condition;
	private String attr1;
	private String attr2;

	@SuppressWarnings("unused")
	private SampleJpo() {
	}

	public SampleJpo(SampleEntity entity) {
		update(entity);
	}

	public void update(SampleEntity entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public SampleEntity toDomain() {
		SampleEntity entity = new SampleEntity(this.getId());
		BeanUtils.copyProperties(this, entity);
		return entity;
	}

	public static List<SampleEntity> toDomains(Iterable<SampleJpo> jpos) {
		return StreamSupport.stream(jpos.spliterator(), false).map(SampleJpo::toDomain).collect(Collectors.toList());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
}