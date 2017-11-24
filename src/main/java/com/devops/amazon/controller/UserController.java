package com.devops.amazon.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devops.amazon.dao.UserDAO;
import com.devops.amazon.model.User;

@Controller
@RequestMapping(value={"/User"})
public class UserController {
	// Methods that return View Pages have to be written here
	
	//Declaring Service Object for calling the DAO IMPl
	
	@Autowired
	UserDAO userDAO;
	
	User user;
	
	@RequestMapping(value={"/","/home"})
	public ModelAndView UserDefault(){
		return new ModelAndView("Home");
	}
	
	@RequestMapping(value={"/SignUp"})
	public ModelAndView UserRegister(){
		return new ModelAndView("Register","command",new User());// Register is the page name
	}
	
	@RequestMapping(value={"/SignUp"},method = RequestMethod.POST)
	public String RegisterUser(ModelMap model,@Valid @ModelAttribute("amazon") User u,BindingResult result){
		//So we have to call service here
		//u is the Object here
		u.setId(101);
		u.setStatus("Active");
		userDAO.create(u);// saving object to DB
		return "redirect:/User/signUp";
	}
	
	@RequestMapping(value="/Logout")
	public String logout(){
		user=null;
		return "redirect:/User/Login";
	}
	
	@RequestMapping(value="/Login")
	public ModelAndView login(){
		return new ModelAndView("login","command",new User());
	}
	
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public String verifyLogin(ModelMap model,@Valid @ModelAttribute("amazon") User u,BindingResult result){
		user=userDAO.read(u);
		if(user.getId()==0){
			//if record not matched redirect to Login 
			return "redirect:/User/Login";
		}
		return "redirect:/User/Welcome";
	}
	
	@RequestMapping(value="/Welcome")
	public ModelAndView welcome(){
		return new ModelAndView("welcome","user",user);// transfering the user object to page
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}
