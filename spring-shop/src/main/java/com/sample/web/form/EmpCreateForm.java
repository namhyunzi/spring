package com.sample.web.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpCreateForm {

	private String name;
	private String tel;
	private String email;
	private int	salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private int deptNo;
}
