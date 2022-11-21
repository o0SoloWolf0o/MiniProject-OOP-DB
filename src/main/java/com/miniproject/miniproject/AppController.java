package com.miniproject.miniproject;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private UserService service;

	@Autowired
	private RequestService service2;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/store")
	public String viewStorePage() {
		return "store";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		service.registerDefaultUser(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = service.get(id);
		List<Role> listRoles = service.listRoles();
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user) {
		service.save(user);
		
		return "redirect:/users";
	}


	@RequestMapping("/request")
	public String viewRequestPage(Model model) {

		String keyword = null;
		return viewPage(model, 1, "name", "asc", keyword);
	}

	@RequestMapping("/request/page/{pageNum}")
	public String viewPage(Model model, 
			@PathVariable(name = "pageNum") int pageNum,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir,
			@Param("keyword") String keyword) {
		
		Page<Request> page = service2.listAll(pageNum, sortField, sortDir, keyword);
		
		List<Request> listRequest = page.getContent();
		
		model.addAttribute("currentPage", pageNum);		
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listRequest", listRequest);

		model.addAttribute("keyword", keyword);
		
		return "requestindex";
	}	
	
	@RequestMapping("/request/new")
	public String showNewRequestForm(Model model) {
		Request request = new Request();
		model.addAttribute("request", request);
		
		return "new_request";
	}
	
	@RequestMapping(value = "/request/save", method = RequestMethod.POST)
	public String saveRequest(@ModelAttribute("request") Request request) {
		service2.save(request);
		
		return "redirect:/";
	}

	@RequestMapping("/request/edit/{id}")
	public ModelAndView showEditRequestForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_request");
		
		Request request = service2.get(id);
		mav.addObject("request", request);
		
		return mav;
	}	

	@RequestMapping("/request/delete/{id}")
	public String deleteRequest(@PathVariable(name = "id") Long id) {
		service2.delete(id);
		
		return "redirect:/";
	}
}
