package com.ntiques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntiques.model.User;
import com.ntiques.service.CategoryService;
import com.ntiques.service.ProductService;
import com.ntiques.service.SubCategoryService;

@Controller
public class MainCntroller {
	@Autowired (required=true)
	private CategoryService categoryService;
	private SubCategoryService subcategoryService;
	private ProductService productService;
	
	@RequestMapping("/")
	public String getHome(Model model) {
		
		model.addAttribute("categoryList", this.categoryService.list());
		model.addAttribute("user", new User());
		return "home";
	}

}
