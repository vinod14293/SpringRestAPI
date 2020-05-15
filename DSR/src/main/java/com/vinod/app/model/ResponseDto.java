package com.vinod.app.model;

public class ResponseDto {

	private String name;
	private String message;
	@Override
	public String toString() {
		return "ResponseDto [name=" + name + ", message=" + message + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
