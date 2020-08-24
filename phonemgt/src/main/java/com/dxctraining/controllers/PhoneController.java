package com.dxctraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.dto.CreatePhoneRequest;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.service.IPhoneService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class PhoneController {

	@Autowired
	private IPhoneService phoneservice;

	@PostConstruct
	public void run() {

		Phone phone1 = new Phone("redmi", 64);
		Phone phone2 = new Phone("vivo", 128);
		phoneservice.add(phone1);
		phoneservice.add(phone2);

	}

	@PostMapping("/addphones")
	@ResponseStatus(HttpStatus.CREATED)
	public Phone create(@RequestBody CreatePhoneRequest requestData) {
		String name = requestData.getName();
		int storagesize = requestData.getStoragesize();

		Phone phone = new Phone(name, storagesize);
		phone = phoneservice.add(phone);
		return phone;
	}

	@GetMapping("/phones")
	public ModelAndView all() {
		List<Phone> phone = phoneservice.phoneList();
		System.out.println("inside computers list");
		ModelAndView modelAndView = new ModelAndView("list", "phones", phone);
		return modelAndView;
	}

}
