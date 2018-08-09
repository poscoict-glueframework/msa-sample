package com.poscoict.sample.domain.proxy.sdo;

import com.poscoict.sample.domain.JsonSerializable;
import com.poscoict.sample.domain.JsonUtil;

public class SampleRdo implements JsonSerializable {
	public static SampleRdo fromJson(String json) {
		return JsonUtil.fromJson(json, SampleRdo.class);
	}

	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
