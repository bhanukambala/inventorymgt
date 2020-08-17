package com.dxctraining.supplier.dao;

import com.dxctraining.supplier.exceptions.*;
import com.dxctraining.supplier.entities.*;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class SupplierDaoImpl implements ISupplierDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Supplier add(Supplier supplier) {
		entityManager.persist(supplier);
		return supplier;
	}

	@Override
	public Supplier findSupplierById(int id) {
		Supplier supplier=entityManager.find(Supplier.class, id);
		if(supplier==null) {
			throw new SupplierNotFoundException("supplier not found for the given id"+id);
		}
		return supplier;
	}

	
	@Override
	public void remove(int id) {
		Supplier supplier=findSupplierById(id);
		entityManager.remove(supplier);
	}
	

}
