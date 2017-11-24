package com.devops.amazon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devops.amazon.dao.CategoryDAO;
import com.devops.amazon.model.Category;
import com.devops.amazon.model.User;

@Controller
@RequestMapping(value="/Admin")
public class AdminController {
	
	@Autowired
	CategoryDAO categoryService;
	
	@RequestMapping(value="/Category")
	public ModelAndView category(){
		return new ModelAndView("category","command",new Category());
	}
	
	@RequestMapping(value="/Category",method=RequestMethod.POST)
	public String addCategory(ModelMap model,@Valid @ModelAttribute("amazon") Category c,BindingResult result){
		categoryService.create(c);
		return "redirect:/Admin/Category";
	}
}
