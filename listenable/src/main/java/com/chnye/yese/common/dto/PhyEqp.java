package com.chnye.yese.common.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class PhyEqp {

	private long id;
	private String name;
	private String code;
	private int type;
	
	public PhyEqp( long id, String name, String code ){
		this.id = id;
		this.name = name;
		this.code = code;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
}
