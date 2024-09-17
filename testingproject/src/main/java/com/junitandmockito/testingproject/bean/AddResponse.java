package com.junitandmockito.testingproject.bean;

public class AddResponse {
	private String message;
	private Integer id;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AddResponse(String message, Integer id) {
		super();
		this.message = message;
		this.id = id;
	}
	

}
