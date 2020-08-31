package com.dxctraining.supplier.controllers;

import com.dxctraining.supplier.dto.CreateSupplierRequest;
import com.dxctraining.supplier.dto.SupplierDto;
import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.supplier.service.ISupplierService;
import com.dxctraining.supplier.util.SupplierUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/suppliers")
public class SupplierController {

	
	@Autowired
	private ISupplierService supplierservice;
	
	@Autowired
	private SupplierUtil util;

	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierDto create(@RequestBody CreateSupplierRequest requestData) {
		Supplier supplier=new Supplier();
		supplier.setName(requestData.getName());
		supplier.setPassword(requestData.getPassword());
		supplier = supplierservice.save(supplier);
		SupplierDto response =util.supplierDto(supplier);
		return response;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto findSupplierBy(@PathVariable("id") String id) {
		Supplier supplier = supplierservice.findSupplierById(id);
		SupplierDto req = util.supplierDto(supplier);
		return req;
	}

}
