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
import com.dxctraining.computer.service.IComputerService;
import com.dxctraining.dto.CreateComputerRequest;
import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.supplier.service.ISupplierService;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
public class ComputerController {
	
		 @Autowired
	 	private ISupplierService supplierservice;
	 @Autowired
	 private IComputerService computerservice;
	
	 
	 @PostConstruct
	    public void run()
	    {
		 
		 Supplier supplier1 = new Supplier("bhanu");
	        Supplier supplier2 = new Supplier("mallika");
	        supplierservice.add(supplier1);
	        supplierservice.add(supplier2);
		Computer computer1=new Computer("hp",supplier1,364);
		Computer computer2=new Computer("dell",supplier2,888);
		computerservice.add(computer1);
		 computerservice.add(computer2);
		 
			    }
	 
	 @PostMapping("/add")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Computer add(@RequestBody CreateComputerRequest requestData) {
	        String name = requestData.getName();
	        String password = requestData.getPassword();
	        int disksize = requestData.getDisksize();
	        Supplier supplier=requestData.getSupplier();
	        Computer computer= new Computer(name, supplier,disksize);
	        computer = computerservice.add(computer);
	        return computer;
	    }
	 
	  @GetMapping("/computers")
	    public ModelAndView all()
	    {
	        List<Computer>computer=computerservice.computerList();
	        System.out.println("inside computers list");
	        ModelAndView modelAndView=new ModelAndView("list","computers",computer);
	        return  modelAndView;
	    }

	    }
	 



