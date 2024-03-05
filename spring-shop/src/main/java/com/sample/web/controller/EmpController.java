package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.mapper.EmpMapper;
import com.sample.service.HrService;
import com.sample.vo.Dept;
import com.sample.vo.Emp;
import com.sample.web.dto.Criteria;
import com.sample.web.dto.ListDto;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;


@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private HrService hrService;

	
	@GetMapping("/detail")
	public String detail(int no, Model model) {
		Emp emp = hrService.getEmployeeDetail(no);
		model.addAttribute("emp", emp);
		return "emp/detail";
	}
	
	@GetMapping("/list")
	public String list(@RequestParam (name = "page", required = false, defaultValue = "1") int page, Model model) {
		Criteria criteria = new Criteria();
		criteria.setPage(page);
		
		ListDto<Emp> dto = hrService.getEmps(criteria);
		model.addAttribute("empList", dto.getItems());
		model.addAttribute("paging", dto.getPaging());
		model.addAttribute("criteria", criteria);
		return "emp/list";
	}
	
	@GetMapping("/add")
	public String form(Model model) {
		List<Dept> depts = hrService.getAllDepts();
		model.addAttribute("deptList", depts);
		
		return "emp/form";
	}
	
	@PostMapping("/add")
	public String add(EmpCreateForm empCreateForm) {
		hrService.addEmployee(empCreateForm);
		return "redirect:list";
	}
	
	@GetMapping("/modify")
	public String modifyForm(int no, Model model) {
		List<Dept> depts = hrService.getAllDepts();
		model.addAttribute("deptList", depts);

		Emp emp = hrService.getEmployeeDetail(no);
		model.addAttribute("emp", emp);
		return "emp/modifyform";
	}
	
	@PostMapping("/modify")
	public String modify(int no, EmpModifyForm empModifyForm) {
		hrService.modifyEmployee(no, empModifyForm);
			return "redirect:detail?no="+ no;
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("no") List<Integer> noList) {
		hrService.deleteEmployees(noList);
		
		return "redirect:list";
	}
	
	@GetMapping("/deleteone")
	public String deleteone(int no) {
		hrService.deletEmployee(no);
		return "redirect:list";
	}
	
	
}
