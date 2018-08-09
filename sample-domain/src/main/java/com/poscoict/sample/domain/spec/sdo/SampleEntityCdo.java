package com.poscoict.sample.domain.spec.sdo;

import com.poscoict.sample.domain.JsonSerializable;

public class SampleEntityCdo implements JsonSerializable {
	private String condition;
	private String attr1;
	private String attr2;

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the attr1
	 */
	public String getAttr1() {
		return attr1;
	}

	/**
	 * @param attr1 the attr1 to set
	 */
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	/**
	 * @return the attr2
	 */
	public String getAttr2() {
		return attr2;
	}

	/**
	 * @param attr2 the attr2 to set
	 */
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

}
