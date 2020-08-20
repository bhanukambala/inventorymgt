package com.dxctraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.computer.entities.Computer;
import com.dxctraining.dto.CreateComputerRequest;
import com.dxctraining.dto.CreatePhoneRequest;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.service.IPhoneService;

import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.supplier.service.ISupplierService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class PhoneController {

	@Autowired
	private ISupplierService supplierservice;
	@Autowired
	private IPhoneService phoneservice;

	@PostConstruct
	public void run() {

		Supplier supplier1 = new Supplier("bhanu");
		Supplier supplier2 = new Supplier("mallika");
		supplierservice.add(supplier1);
		supplierservice.add(supplier2);
		Phone phone1 = new Phone("redmi", supplier1, 64);
		Phone phone2 = new Phone("vivo", supplier2, 128);
		phoneservice.add(phone1);
		phoneservice.add(phone2);

	}
	 @PostMapping("/add")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Phone add(@RequestBody CreatePhoneRequest requestData) {
	        String name = requestData.getName();
	        String password = requestData.getPassword();
	        int storagesize = requestData.getStoragesize();
	        Supplier supplier=requestData.getSupplier();
	        Phone phone= new Phone(name, supplier,storagesize);
	        phone = phoneservice.add(phone);
	        return phone;
	    }
	@GetMapping("/phones")
	public ModelAndView all() {
		List<Phone> computer = phoneservice.phoneList();
		System.out.println("inside computers list");
		ModelAndView modelAndView = new ModelAndView("list", "computers", computer);
		return modelAndView;
	}

}
