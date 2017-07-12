package com.zgp.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zgp.category.pojo.CategoryPojo;
import com.zgp.category.serviceimpl.CategoryServiceImpl;

@Controller
public class categorycontroller {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@RequestMapping(value="/getcategory")
	public String getcategory(Model model) throws Exception{
		List<CategoryPojo> pojos = categoryServiceImpl.getCategorys();
		model.addAttribute("categorys", pojos);
		return "/jsps/left";
	}
	
	
}
