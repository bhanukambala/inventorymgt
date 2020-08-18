package com.dxctraining.Ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.service.IComputerService;
import com.dxctraining.item.entites.Item;
import com.dxctraining.item.exceptions.InvalidArgumentException;
import com.dxctraining.item.exceptions.ItemNotFoundException;
import com.dxctraining.item.service.IItemService;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.service.IPhoneService;
import com.dxctraining.supplier.entities.Supplier;
import com.dxctraining.supplier.service.ISupplierService;

import javax.annotation.PostConstruct;

@Component
public class InventoryUi {
	@Autowired
	private IItemService itemservice;
	@Autowired
	private ISupplierService supplierservice;
	@Autowired
	private IComputerService computerservice;
	@Autowired
	private IPhoneService phoneservice;
	
	@PostConstruct
	public void runUi() {
		try {
			Supplier supplier1=new Supplier("bhanu");
			Supplier supplier2=new Supplier("mallika");
			supplierservice.add(supplier1);
			supplierservice.add(supplier2);
			Computer computer1=new Computer("hp",supplier1,364);
			computerservice.add(computer1);
			Phone phone1=new Phone("redmi",supplier2,64);
			phoneservice.add(phone1);
		
			
			int id1=computer1.getId();
			Computer fetched1=computerservice.findComputerById(id1);
			System.out.println("item fetched "+fetched1.getId()+""+fetched1.getName()+""+fetched1.getSupplier()+""+fetched1.getDisksize());
			int id2=phone1.getId();
			Phone fetched2=phoneservice.findPhoneById(id2);
			System.out.println("item fetched "+fetched2.getId()+""+fetched2.getName()+""+fetched2.getSupplier()+""+fetched2.getStoragesize());
	
		}
		
		 catch (ItemNotFoundException e) {
	            e.printStackTrace();
	        } catch (InvalidArgumentException e) {
	            e.printStackTrace();
	        }
	}
}
