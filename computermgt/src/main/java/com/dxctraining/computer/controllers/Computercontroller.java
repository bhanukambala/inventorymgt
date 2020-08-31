package com.dxctraining.computer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.computer.dto.*;
import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.service.IComputerService;
import com.dxctraining.computer.util.*;
import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/computers")
public class Computercontroller {

	@Autowired
	private IComputerService computerservice;
	
	@Autowired
	private ComputerUtil util;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ComputerDto add(@RequestBody CreateComputerRequest requestData) {
		String name = requestData.getName();
		int disksize = requestData.getDisksize();
		int supplierid=requestData.getSupplierid();
		Computer computer = new Computer(supplierid,name, disksize);
		computer = computerservice.save(computer);
		SupplierDto supplierDto = fetchFromSupplierById(supplierid);
		ComputerDto response = util.computerDto(computer, supplierid);
		return response;
	}
	@GetMapping("/get/{id}")
	public ComputerDto getComputer(@PathVariable("id") int id) {
		Computer computer = computerservice.findComputerById(id);
		int supplierId = computer.getSupplierid();
		SupplierDto supplierReq = fetchFromSupplierById(supplierId);
		ComputerDto response =util.computerDto(computer, supplierId);
		return response;
	}



	public SupplierDto fetchFromSupplierById(int supplierId) {
		String url = "http://localhost:8989/suppliers/get/" + supplierId;
		SupplierDto supplierreq = restTemplate.getForObject(url, SupplierDto.class);
		return supplierreq;

	}

	
	@GetMapping("/supplier/{supplierId}")
	public List<ComputerDto> fetchAllComputers(@PathVariable("supplierid") int supplierid) {
		List<Computer> list = computerservice.findComputerBySupplier(supplierid);
		List<ComputerDto> response = new ArrayList<>();
		SupplierDto supplierreq = fetchFromSupplierById(supplierid);
		for (Computer comp : list) {
			ComputerDto computerReq = util.computerDto(comp, supplierid);
			response.add(computerReq);
		}
		return response;
	}

}
