package com.dxctraining.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.supplier.dao.ISupplierDao;
import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.supplier.exception.*;


@Service
public class SupplierServiceImpl implements ISupplierService {
	
	@Autowired
	private ISupplierDao dao;
	


	@Override
	public Supplier save(Supplier supplier) {
		supplier = dao.save(supplier);
		return supplier;
	}

	@Override
	public Supplier findSupplierById(String id) {
		Optional<Supplier> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new SupplierNotFoundException("supplier not found for id= " + id);
		}
		Supplier supplier = optional.get();
		return supplier;
	}

	@Override
	public void remove(String id) {
		dao.deleteById(id);
	}

	@Override
	public List<Supplier> findSupplierByName(String name) {
		List<Supplier> list = dao.findSupplierByName(name);
		return list;
	}

	@Override
	public List<Supplier> supplierList() {
		List<Supplier> supplier = dao.findAll();
		return supplier;
	}
		

}
