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

import com.ntiques.model.Supplier;
import com.ntiques.model.Supplier;
import com.ntiques.service.SupplierService;
import com.ntiques.service.SupplierService;


@SessionAttributes({ "Supplier" })
@Controller
public class SupplierController {

	@Autowired    (required=true)
	private SupplierService SupplierService;
	
	
	
	
	
	@RequestMapping(value = "/suppliers",method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", this.SupplierService.list());
		return "supplier";
	}
	
	@RequestMapping(value= "/supplier/add")
	public String addSupplier(@ModelAttribute("supplier") Supplier Supplier){
		
	
			SupplierService.saveOrUpdate(Supplier);
		
		return "redirect:/suppliers";
		
	}
	
	@RequestMapping("supplier/remove/{id}")
    public String deleteSupplier(@PathVariable("id") int id,ModelMap model) throws Exception{
		
       try {
		SupplierService.delete(id);
		model.addAttribute("message","Successfully Added");
	} catch (Exception e) {
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
	}
       //redirectAttrs.addFlashAttribute(arg0, arg1)
        return "redirect:/suppliers";
    }
 
    @RequestMapping("supplier/edit/{id}")
    public String editSupplier(@PathVariable("id") int id, Model model){
    	System.out.println("editSupplier");
        model.addAttribute("supplier", this.SupplierService.get(id));
        model.addAttribute("listSuppliers", this.SupplierService.list());
        return "supplier";
    }


}
