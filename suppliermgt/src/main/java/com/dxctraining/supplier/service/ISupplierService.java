package com.dxctraining.supplier.service;

import java.util.List;

import com.dxctraining.supplier.entities.Supplier;

public interface ISupplierService {
		Supplier findSupplierById(String id);
		List<Supplier> supplierList();
		List<Supplier> findSupplierByName(String name);
		void remove(String id);
		Supplier save(Supplier supplier);
}
