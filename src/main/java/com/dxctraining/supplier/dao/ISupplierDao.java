package com.dxctraining.supplier.dao;

import com.dxctraining.supplier.entities.Supplier;

public interface ISupplierDao {
	Supplier add(Supplier supplier);
	Supplier findSupplierById(int id);
		 void remove(int id);
}
