package com.dxctraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.service.IComputerService;
import com.dxctraining.dto.CreateComputerRequest;


import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/computers")
public class Computercontroller {

	@Autowired
	private IComputerService computerservice;

	@PostConstruct
	public void run() {
		Computer computer1 = new Computer("hp", 364);
		Computer computer2 = new Computer("dell", 888);
		computerservice.add(computer1);
		computerservice.add(computer2);

	}

	@PostMapping("/addcomputers")
	@ResponseStatus(HttpStatus.CREATED)
	public Computer add(@RequestBody CreateComputerRequest requestData) {
		String name = requestData.getName();
		int disksize = requestData.getDisksize();
		Computer computer = new Computer(name, disksize);
		computer = computerservice.add(computer);
		return computer;
	}

	@GetMapping("/computers")
	public ModelAndView all() {
		List<Computer> computer = computerservice.computerList();
		System.out.println("inside computers list");
		ModelAndView modelAndView = new ModelAndView("list", "computers", computer);
		return modelAndView;
	}

}
