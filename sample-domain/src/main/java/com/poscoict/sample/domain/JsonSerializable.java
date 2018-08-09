package com.poscoict.sample.domain;

public interface JsonSerializable {
	default String toJson() {
		return JsonUtil.toJson(this);
	}
}
