package com.dxctraining.supplier.dao;

import java.util.List;

import com.dxctraining.supplier.entities.Supplier;

public interface ISupplierDao {
	Supplier add(Supplier supplier);
	Supplier findSupplierById(int id);
		 void remove(int id);
		List<Supplier> supplierList();
}
