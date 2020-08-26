package com.dxctraining.computer.service;

import java.util.List;

import com.dxctraining.computer.entities.Computer;

public interface IComputerService {
	Computer add(Computer  computer);
		 void remove(int id);
		Computer findComputerById(int id);
		List<Computer> computerList();
		List<Computer> findComputerBySupplier(int supplierid);

}
