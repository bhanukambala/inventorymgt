package com.dxctraining.computer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.computer.dao.IComputerDao;
import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ComputerServiceImpl implements IComputerService {

	@Autowired
	private IComputerDao dao;

	@Override
	public Computer save(Computer computer) {
		display(computer);
		computer = dao.save(computer);
		return computer;
	}

	public void display(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is null");
		}

	}
	 @Override
	    public List<Computer> computerList() {
	        List<Computer>result=dao.computerList();
	        return result;
	    }

	@Override
	public Computer findComputerById(int id) {
		Computer computer = dao.findComputerById(id);
		return computer;
	}
	@Override
	public List<Computer> findComputerBySupplier(int supplierId){
		List<Computer>list=dao.findComputerBySupplier(supplierId);
		return list;
	}
	@Override
	public void remove(int id) {
		dao.remove(id);

	}

}
