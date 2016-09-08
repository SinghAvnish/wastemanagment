package com.ntiques.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ntiques.model.Category;
import com.ntiques.model.SubCategory;
import com.ntiques.service.CategoryService;
import com.ntiques.service.SubCategoryService;

@Controller
public class SubCategoryController {
	@Autowired	(required=true)
	private SubCategoryService subcategoryService;
	@Autowired	(required=true)
	private CategoryService categoryService;

	@RequestMapping(value = "subcategories", method = RequestMethod.GET)
	public String listSubCategorys(Model model) {
		model.addAttribute("subcategory", new SubCategory());
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryService.list());
		model.addAttribute("subcategoryList", this.subcategoryService.list());
		return "subcategory";
	}
	//For add and update category both
			@RequestMapping(value= "/subcategory/add")
			public String addSubCategory(@Valid @ModelAttribute("subcategory") SubCategory subcategory,BindingResult result){
				if (result.hasErrors())
				{
					return "subcategory";
				}
				else {
					Category category = categoryService.getByName(subcategory.getCategory().getName());
					categoryService.saveOrUpdate(category);  
					subcategory.setCategory(category);
					subcategory.setCat_id(category.getId());
					subcategoryService.saveOrUpdate(subcategory);
					
					return "redirect:/subcategorylist";
				}
				
   }
			@RequestMapping("subcategory/remove/{id}")
		    public String deleteSubCategory(@PathVariable("id") String id,ModelMap model) throws Exception{
				
		       try {
				subcategoryService.delete(id);
				model.addAttribute("message","Successfully Added");
			} catch (Exception e) {
				model.addAttribute("message",e.getMessage());
				e.printStackTrace();
			}
		       //redirectAttrs.addFlashAttribute(arg0, arg1)
		        return "redirect:/subcategorylist";
		    }
		 
		    @RequestMapping("subcategory/edit/{id}")
		    public String editSubCategory(@PathVariable("id") String id, Model model){
		    	System.out.println("editSubCategory");
		        model.addAttribute("subcategory", this.subcategoryService.get(id));
		        model.addAttribute("subcategoryList", this.subcategoryService.list());
		        model.addAttribute("categoryList", this.categoryService.list());
		        return "subcategory";
		    }
		    @RequestMapping("/subcategorylist")
		    public String getList(Model model){
		    	model.addAttribute("subcategoryList", this.subcategoryService.list());
		    	return "subcategorylist";

		    	
		    }


}