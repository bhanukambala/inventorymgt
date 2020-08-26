package com.dxctraining.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.supplier.dao.ISupplierDao;
import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.exception.InvalidArgumentException;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {
	
	@Autowired
	private ISupplierDao dao;
	

	@Override
	public Supplier add(Supplier supplier) {
		display(supplier);
		supplier=dao.add(supplier);
		return supplier;
	}

	public void display(Object arg) {
		if(arg==null) {
			throw new InvalidArgumentException("argument is null");
		}
		
	}

	@Override
	public Supplier findSupplierById(int id) {
		Supplier supplier=dao.findSupplierById(id);
		return supplier;
	}
	  @Override
	    public List<Supplier> supplierList() {
	        List<Supplier>result=dao.supplierList();
	        return result;
	    }


	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}
	

}
