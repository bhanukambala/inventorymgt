package com.dxctraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.dto.PhoneReq;
import com.dxctraining.dto.Phones;
import com.dxctraining.dto.CreatePhoneRequest;
import com.dxctraining.dto.SupplierRequest;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.service.IPhoneService;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PhoneController {

	@Autowired
	private IPhoneService phoneservice;
	
	@Autowired
	private RestTemplate restTemplate;


	@PostMapping("/addphones")
	@ResponseStatus(HttpStatus.CREATED)
	public Phone create(@RequestBody CreatePhoneRequest requestData) {
		String name = requestData.getName();
		int storagesize = requestData.getStoragesize();
		int supplierid=requestData.getSupplierid();
		Phone phone = new Phone(name, storagesize,supplierid);
		phone = phoneservice.add(phone);
		return phone;
	}
	@GetMapping("/get/{id}")
	public PhoneReq getPhone(@PathVariable("id") int id) {
		Phone phone = phoneservice.findPhoneById(id);
		int supplierId = phone.getSupplierid();
		SupplierRequest supplierReq = fetchFromSupplierById(supplierId);
		PhoneReq response = Phones.phoneReq(phone, supplierId);
		return response;
	}



	public SupplierRequest fetchFromSupplierById(int supplierId) {
		String url = "http://localhost:8989/suppliers/get/" + supplierId;
		SupplierRequest supplierreq = restTemplate.getForObject(url, SupplierRequest.class);
		return supplierreq;

	}
	@GetMapping("/supplier/{supplierId}")
	public List<PhoneReq> fetchAllComputers(@PathVariable("supplierid") int supplierid) {
		List<Phone> list =phoneservice.findPhoneBySupplier(supplierid);
		List<PhoneReq> response = new ArrayList<>();
		SupplierRequest supplierreq = fetchFromSupplierById(supplierid);
		for (Phone phn : list) {
			PhoneReq phoneReq = Phones.phoneReq(phn, supplierid);
			response.add(phoneReq);
		}
		return response;
	}

}
