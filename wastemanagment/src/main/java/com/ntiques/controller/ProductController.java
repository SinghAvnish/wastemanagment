package com.ntiques.controller;



import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

import com.ntiques.model.Product;
import com.ntiques.model.SubCategory;
import com.ntiques.model.Supplier;
import com.ntiques.service.ProductService;
import com.ntiques.service.SubCategoryService;
import com.ntiques.service.SupplierService;

@Controller

public class ProductController {
	
	Path path;
	@Autowired	(required=true)
	private ProductService productservice;
	@Autowired	(required=true)
	private SupplierService supplierservice;
	@Autowired  (required=true)
	private SubCategoryService subcategoryService;
	
	@RequestMapping(value = "products", method = RequestMethod.GET)
	
	public String listProducts(Model model) 
	{
		model.addAttribute("product", new Product());
		model.addAttribute("subcategory", new SubCategory());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("SubCategoryList", this.subcategoryService.list());
		model.addAttribute("productList", this.productservice.list());
		model.addAttribute("supplierList",this.supplierservice.list());
		return "product";
	}

	@RequestMapping(value= "/product/add")
	public String addProduct(@ModelAttribute("product") Product product,HttpServletRequest request){
		
			SubCategory subcategory = subcategoryService.getByName(product.getSubcategory().getName());
			subcategoryService.saveOrUpdate(subcategory);
			
			
			Supplier supplier = supplierservice.getByName(product.getSupplier().getName());
			supplierservice.saveOrUpdate(supplier);
			
			product.setSupplier(supplier);
			product.setSubcategory(subcategory);
			product.setSub_id(subcategory.getId());
			product.setSupplier_id(supplier.getId());
			
			productservice.saveOrUpdate(product);
			
			MultipartFile image = product.getImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory +  "/resources/images/" + product.getId() + ".jpg");

			if (image != null && !image.isEmpty()) {
				try {
					image.transferTo(new File(path.toString()));
					System.out.println("Image successfully uploaded" + path);
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException("Product image saving failed", ex);
				}
			}		
	
			return "redirect:/productlist";	
		}
		

	
	

	@RequestMapping("/productremove/{id}")
    public String deleteproduct(@PathVariable("id") int id,ModelMap model) throws Exception{
		
       try {
		productservice.delete(id);
		model.addAttribute("message","Successfully Deleted");
	} catch (Exception e) 
       {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
       //redirectAttrs.addFlashAttribute(arg0, arg1)
        return "redirect:/productlist";
    }
 


	 @RequestMapping("/productview{id}")
	    public String viewproduct(@PathVariable("id") int id, Model model){
	    	System.out.println("View");
	        model.addAttribute("product", this.productservice.get(id));
	        model.addAttribute("productdetails", this .productservice.get(id));
	        return "viewproduct";
	    }
	 
	 
	 @RequestMapping("product/edit/{id}")
		public String editproduct(@PathVariable("id") int id, Model model) {
			System.out.println("editProduct");
			model.addAttribute("product", this.productservice.get(id));
			model.addAttribute("productList", this.productservice.list());
			model.addAttribute("SubCategoryList", this .subcategoryService.list());
			model.addAttribute("supplierList", this .supplierservice.list());
			
			
			return "product";
		}
		
  
	 @RequestMapping("/productlist")
    public String getList(Model model){
    	model.addAttribute("productList", this.productservice.list());
    	return "productlist";

    	
    }
	 
	 @RequestMapping("/productdisplay")
	    public String getdisplay(Model model)
	 {
	    	model.addAttribute("productdisplay", this.productservice.productdisplay(0));
	    	return "productdisplay";
	    	
	 }


}
