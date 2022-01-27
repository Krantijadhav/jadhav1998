package com.grid.dynamic.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.grid.dynamic.Entity.Student;
import com.grid.dynamic.Service.StudentService;
@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	
	
	
	@GetMapping("/")
	public String home(Model m) 
	{
	List<Student> prn = service.getAllPrn();
	m.addAttribute("prn",prn);
	return"index";
	}

	@GetMapping("/add")
	public String addRecord()
	{
		return"student";
}
	

	@PostMapping("/register")
	public String addRecord(@ModelAttribute Student p,HttpSession session)
	{
		System.out.println(p);
		service.addRecord(p);
		session.setAttribute("msg", "Record Added Successfuly...");
		
		return"redirect:/"; 
		
	}	
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable int id,Model m)
		{
			Student p=service.getPrnById(id);
			m.addAttribute("prn",p);
			return"edit";
		}
		@PostMapping("/update")
		public String updatePrn(@ModelAttribute Student p,HttpSession session)
		{
			service.addRecord(p);
			session.setAttribute("msg","Record Updated Successfuly....");
			return "redirect:/";
		}
		@GetMapping("/delete/{id}")
		public String deletePrn(@PathVariable int id,HttpSession session)
		{
		service.deletePrn(id);
		session.setAttribute("msg","Record Deleted Successfuly...");
		return "redirect:/";
		
		
		}
		
	
}

