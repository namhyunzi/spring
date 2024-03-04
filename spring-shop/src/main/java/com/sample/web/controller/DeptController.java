package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.HrService;
import com.sample.vo.Dept;
import com.sample.web.form.DeptCreateForm;

@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	private HrService hrService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Dept> deptList = hrService.getAllDepts();
		model.addAttribute("deptList", deptList);
		
		return "dept/list";
	}
	
	@GetMapping("/add")
	public String form(Model model) {
		
		return "dept/form";
	}
	
	@PostMapping("/add")
	public String add(DeptCreateForm deptCreateForm) {
		hrService.addProduct(deptCreateForm);
		
		return "redirect:list";
	}
}

