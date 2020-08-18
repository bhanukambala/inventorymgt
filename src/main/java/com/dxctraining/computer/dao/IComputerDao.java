package com.dxctraining.computer.dao;

import com.dxctraining.computer.entities.Computer;

public interface IComputerDao {
	Computer add(Computer  computer);
		 void remove(int id);
		Computer findComputerById(int id);
}
