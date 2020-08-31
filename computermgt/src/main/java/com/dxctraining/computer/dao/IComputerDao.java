package com.dxctraining.computer.dao;

import java.util.List;

import com.dxctraining.computer.entities.Computer;

public interface IComputerDao {
		 void remove(int id);
		Computer findComputerById(int id);
		List<Computer> computerList();
		List<Computer> findComputerBySupplier(int supplierId);
		Computer save(Computer computer);
}
