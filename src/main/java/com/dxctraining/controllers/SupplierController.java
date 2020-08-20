package com.dxctraining.controllers;

import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.supplier.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class SupplierController {

	@Autowired
	private ISupplierService supplierservice;

	@PostConstruct
	public void run() {
		Supplier supplier1 = new Supplier("bhanu");
		Supplier supplier2 = new Supplier("mallika");
		supplierservice.add(supplier1);
		supplierservice.add(supplier2);
	}

	@GetMapping("/profile")
	public ModelAndView employeeDetails(@RequestParam("id") int id) {
		Supplier supplier = supplierservice.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("details", "supplier", supplier);
		return modelAndView;
	}

	@GetMapping("/suppliers")
	public ModelAndView all() {
		List<Supplier> supplierList = supplierservice.supplierList();
		System.out.println("inside suppliers list");
		ModelAndView modelAndView = new ModelAndView("list", "suppliers", supplierList);
		return modelAndView;
	}
	@GetMapping("/register")
	public ModelAndView registerSupplier() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("name") String name) {
		System.out.println("inside processregister method, name=" + name);
		Supplier supplier = new Supplier(name);
		supplier = supplierservice.add(supplier);
		ModelAndView mv = new ModelAndView("details", "supplier", supplier);
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@GetMapping("/processlogin")
	public ModelAndView processLogin(@RequestParam("name") String name, @RequestParam("id") int id) {
		Supplier supplier = supplierservice.findSupplierById(id);
		ModelAndView mv = new ModelAndView("details", "supplier", supplier);
		return mv;
	}
}
