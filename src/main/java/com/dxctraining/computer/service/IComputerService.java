package com.dxctraining.computer.service;

import com.dxctraining.computer.entities.Computer;

public interface IComputerService {
	Computer add(Computer  computer);
		 void remove(int id);
		Computer findComputerById(int id);

}
