package com.dxctraining.phone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.phone.dto.*;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.service.IPhoneService;
import com.dxctraining.phone.util.PhoneUtil;


import java.util.ArrayList;
import java.util.List;

@Controller
public class PhoneController {

	@Autowired
	private IPhoneService phoneservice;
	
	@Autowired
	private PhoneUtil util;
	
	@Autowired
	private RestTemplate restTemplate;


	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public PhoneDto create(@RequestBody CreatePhoneRequest requestData) {
		String name = requestData.getName();
		int storagesize = requestData.getStoragesize();
		int supplierid=requestData.getSupplierid();
		Phone phone = new Phone(name, storagesize,supplierid);
		phone = phoneservice.save(phone);
		SupplierDto supplierDto = fetchFromSupplierById(supplierid);
		PhoneDto response =util.phoneDto(phone, supplierid);
		return response;
	}
	@GetMapping("/get/{id}")
	public PhoneDto getPhone(@PathVariable("id") int id) {
		Phone phone = phoneservice.findPhoneById(id);
		int supplierId = phone.getSupplierid();
		SupplierDto supplierReq = fetchFromSupplierById(supplierId);
		PhoneDto response = util.phoneDto(phone, supplierId);
		return response;
	}



	public SupplierDto fetchFromSupplierById(int supplierId) {
		String url = "http://localhost:8989/suppliers/get/" + supplierId;
		SupplierDto supplierreq = restTemplate.getForObject(url, SupplierDto.class);
		return supplierreq;

	}
	@GetMapping("/supplier/{supplierId}")
	public List<PhoneDto> fetchAllComputers(@PathVariable("supplierid") int supplierid) {
		List<Phone> list =phoneservice.findPhoneBySupplier(supplierid);
		List<PhoneDto> response = new ArrayList<>();
		SupplierDto supplierreq = fetchFromSupplierById(supplierid);
		for (Phone phn : list) {
			PhoneDto phoneReq =util.phoneDto(phn, supplierid);
			response.add(phoneReq);
		}
		return response;
	}

}
