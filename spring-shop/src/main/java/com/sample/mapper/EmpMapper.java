package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sample.vo.Emp;

@Mapper
public interface EmpMapper {
	
	List<Emp> getAllEmps();

	void insertEmp(Emp emp);

	void modifyEmployees(int no);
	
	Emp getEmployeeByNo(int no);

	void modifyEmployees(Emp emp);

	void deleteEmployees(@Param("noList") List<Integer> noList);
	
}
