package com.dxctraining.supplier.dao;

import com.dxctraining.exception.*;

import com.dxctraining.supplier.entities.*;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


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
	    public List<Supplier> supplierList() {
	        String jpaQuery = "from Supplier";
	       TypedQuery<Supplier>query= entityManager.createQuery(jpaQuery, Supplier.class);
	        List<Supplier> resultList = query.getResultList();
	        return resultList;
	    }
	 
	@Override
	public void remove(int id) {
		Supplier supplier=findSupplierById(id);
		entityManager.remove(supplier);
	}
	

}
