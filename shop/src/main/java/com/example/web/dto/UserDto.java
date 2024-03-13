package com.example.web.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	private int no;
	private String id;
	private String name;
	private String tel;
	private String email;
	@JsonFormat(pattern = "M월 d일")
	private Date birth;
	@JsonFormat(pattern = "yyyy월 M월 d일")
	private Date createdDate;
}
