package com.poscoict.sample.domain.entity;

import java.io.Serializable;

import com.fasterxml.uuid.Generators;
import com.poscoict.sample.domain.JsonSerializable;
import com.poscoict.sample.domain.JsonUtil;

public class SampleEntity implements Serializable, JsonSerializable {
	private static final long serialVersionUID = 1L;
	private final String id;

	public SampleEntity() {
		this.id = Generators.timeBasedGenerator().generate().toString();
	}

	public SampleEntity(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	// 공통 : util성
	public static SampleEntity fromJson(String json) {
		return JsonUtil.fromJson(json, SampleEntity.class);
	}

	// TOOD : 여기서부터 개발자가 직접 추가할 항목과 getter/setter 들임.
	private String condition;
	private String attr1;
	private String attr2;

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