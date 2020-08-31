package com.dxctraining.supplier.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.dxctraining.supplier.entities.Supplier;

public interface ISupplierDao extends MongoRepository<Supplier, String>{
	
		List<Supplier> findSupplierByName(String name);
}
