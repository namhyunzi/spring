package com.example.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

	private String id;
	private String password;
	private String name;
	private String tel;
	private String email;
	private Date createDate;
	private Date updatedDate;
	
}
