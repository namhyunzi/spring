package com.example.rest;

import java.util.List;

import org.springframework.http.HttpStatus;

public class RestResponse<T> {

	private HttpStatus status;
	private String message;
	private List<T> items;
	
	private RestResponse(HttpStatus status, String message, List<T> items) {
		this.status = status;
		this.message = message;
		this.items = items;
	}
	
	public String getMessage() {
		return message;
	}
	
	public List<T> getItems() {
		return items;
	}
	
	public int getStatus() {
		return status.value();
	}
	
	public static <T> RestResponse<T> getResponse(HttpStatus status, String message, List<T> items) {
		return new RestResponse<T>(status, message, items);
	}
	
	// 조회 결과가 여러개  
	public static <T> RestResponse<T> getResponse(List<T> items) {
		return getResponse(HttpStatus.OK, HttpStatus.OK.toString(), items);
	}
	
	// 조회 결과가 한개 
	public static <T> RestResponse<T> getResponse(T item) {
		return getResponse(HttpStatus.OK, HttpStatus.OK.toString(), List.of(item));
	}
	
	
	public static RestResponse<Void> getResponse(String message) {
		return getResponse(HttpStatus.OK, message , List.of());
	}
	
	// 에러 
	public static RestResponse<Void> getErrorResponse(HttpStatus status, String message) {
		return getResponse(status, message, List.of());
	}
}
