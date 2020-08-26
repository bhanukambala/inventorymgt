package com.dxctraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.service.IComputerService;
import com.dxctraining.dto.*;


import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/computers")
public class Computercontroller {

	@Autowired
	private IComputerService computerservice;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addcomputers")
	@ResponseStatus(HttpStatus.CREATED)
	public Computer add(@RequestBody CreateComputerRequest requestData) {
		String name = requestData.getName();
		int disksize = requestData.getDisksize();
		int supplierid=requestData.getSupplierid();
		Computer computer = new Computer(supplierid,name, disksize);
		computer = computerservice.add(computer);
		return computer;
	}
	@GetMapping("/get/{id}")
	public ComputerReq getComputer(@PathVariable("id") int id) {
		Computer computer = computerservice.findComputerById(id);
		int supplierId = computer.getSupplierid();
		SupplierRequest supplierReq = fetchFromSupplierById(supplierId);
		ComputerReq response = Computers.computerReq(computer, supplierId);
		return response;
	}



	public SupplierRequest fetchFromSupplierById(int supplierId) {
		String url = "http://localhost:8989/suppliers/get/" + supplierId;
		SupplierRequest supplierreq = restTemplate.getForObject(url, SupplierRequest.class);
		return supplierreq;

	}

	
	@GetMapping("/supplier/{supplierId}")
	public List<ComputerReq> fetchAllComputers(@PathVariable("supplierid") int supplierid) {
		List<Computer> list = computerservice.findComputerBySupplier(supplierid);
		List<ComputerReq> response = new ArrayList<>();
		SupplierRequest supplierreq = fetchFromSupplierById(supplierid);
		for (Computer comp : list) {
			ComputerReq computerReq = Computers.computerReq(comp, supplierid);
			response.add(computerReq);
		}
		return response;
	}

}
