package com.ntiques.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ntiques.model.Category;
import com.ntiques.service.CategoryService;





@SessionAttributes({ "Category" })
@Controller

public class CategoryController 
{
	@Autowired    (required=true)
	private CategoryService categoryService;
	
	

	@RequestMapping(value = "/categories",method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryService.list());
		return "category";
	}
	
	@RequestMapping(value= "category/add")
	public String addCategory(@ModelAttribute("category") Category category){
		
	
			categoryService.saveOrUpdate(category);
		
		return "redirect:/categories";
		
	}
	
	@RequestMapping("categoryremove/{id}")
    public String deleteCategory(@PathVariable("id") int id,ModelMap model) throws Exception{
		
       try {
		categoryService.delete(id);
		model.addAttribute("message","Successfully Deleted");
	} catch (Exception e) {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
        return "redirect:/categories";
    }
 
    @RequestMapping("categoryedit/{id}")
    public String editCategory(@PathVariable("id") int id, Model model){
    	System.out.println("editCategory");
        model.addAttribute("category", this.categoryService.get(id));
        model.addAttribute("listCategories", this.categoryService.list());
        return "category";
    }
    



}

