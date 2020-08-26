package com.dxctraining.controllers;

import com.dxctraining.dto.SupplierRequest;
import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.supplier.service.ISupplierService;

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

	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierRequest create(@RequestBody SupplierRequest requestData) {
		Supplier supplier=new Supplier();
		supplier.setName(requestData.getName());
		supplier.setPassword(requestData.getPassword());
		supplier = supplierservice.add(supplier);
		SupplierRequest supplierReq =supplierutil (supplier);
		return supplierReq;
	}

	private SupplierRequest supplierutil(Supplier supplier) {
		SupplierRequest req = new SupplierRequest();
		req.setId(supplier.getId());
		req.setName(supplier.getName());
		req.setPassword(supplier.getPassword());
		return req;
		}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierRequest findSupplierBy(@PathVariable("id") int id) {
		Supplier supplier = supplierservice.findSupplierById(id);
		SupplierRequest req = supplierutil(supplier);
		return req;
	}

}
