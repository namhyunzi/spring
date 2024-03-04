package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.DeptMapper;
import com.sample.mapper.EmpMapper;
import com.sample.vo.Dept;
import com.sample.vo.Emp;
import com.sample.vo.Product;
import com.sample.web.form.DeptCreateForm;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;

@Service
public class HrService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private EmpMapper empMapper;
	
	public List<Dept> getAllDepts() {
		return deptMapper.getAllDepts();
	}
	
	public void addProduct(DeptCreateForm form) {
		Dept dept = Dept.builder()
						.name(form.getName())
						.tel(form.getTel())
						.fax(form.getFax())
						.build();
		
		deptMapper.insertDept(dept);
	}
	
	public List<Emp> getAllEmps() {
		return empMapper.getAllEmps();
	}
	
	public void addEmployee(EmpCreateForm form) {
		
		Dept dept = Dept.builder()
					.no(form.getDeptNo())
					.build();
		
		Emp emp = Emp.builder()
					 .name(form.getName())
					 .tel(form.getTel())
					 .email(form.getEmail())
					 .salary(form.getSalary())
					 .hireDate(form.getHireDate())
					 .dept(dept)
					 .build();
		
		
		empMapper.insertEmp(emp);
	}
	
	public Emp getEmployeeDetail(int no) {
		return empMapper.getEmployeeByNo(no);
	}


	public void modifyEmployee(int no, EmpModifyForm empModifyForm) {
		
		Dept dept = Dept.builder()
				.no(empModifyForm.getDeptNo())
				.build();
	
		Emp emp = Emp.builder()
				 .no(no)
				 .name(empModifyForm.getName())
				 .tel(empModifyForm.getTel())
				 .email(empModifyForm.getEmail())
				 .salary(empModifyForm.getSalary())
				 .hireDate(empModifyForm.getHireDate())
				 .dept(dept)
				 .build();
		
		empMapper.modifyEmployees(emp);
		
	}

	public void deleteEmployees(List<Integer> noList) {
		empMapper.deleteEmployees(noList);
		
	}
}
