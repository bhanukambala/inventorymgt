package com.dxctraining.computer.dao;

import java.util.List;

import com.dxctraining.computer.entities.Computer;

public interface IComputerDao {
	Computer add(Computer  computer);
		 void remove(int id);
		Computer findComputerById(int id);
		List<Computer> computerList();
}
