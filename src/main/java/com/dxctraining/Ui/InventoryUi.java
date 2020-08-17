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
	private ISupplierService supplierservice;
	private IComputerService computerservice;
	private IPhoneService phoneservice;
	
	@PostConstruct
	public void runUi() {
		try {
			Supplier supplier1=new Supplier(1,"bhanu");
			Supplier supplier2=new Supplier(2,"mallika");
			supplierservice.add(supplier1);
			supplierservice.add(supplier2);
			Computer computer1=new Computer(1,"hp",supplier1,364,101);
			computerservice.add(computer1);
			Phone phone1=new Phone(2,"redmi",supplier2,64,73);
			phoneservice.add(phone1);
			
			int serialnum1=computer1.getSerialnum();
			Computer fetched1=computerservice.findComputerBySerialnum(serialnum1);
			System.out.println("item fetched "+fetched1.getId()+""+fetched1.getName()+""+fetched1.getSupplier()+""+fetched1.getDisksize()+""+fetched1.getSerialnum());
			int serialnum2=phone1.getSerialnum();
			Phone fetched2=phoneservice.findPhoneBySerialnum(serialnum2);
			System.out.println("item fetched "+fetched2.getId()+""+fetched2.getName()+""+fetched2.getSupplier()+""+fetched2.getStoragesize()+""+fetched2.getSerialnum());
		}
		 catch (ItemNotFoundException e) {
	            e.printStackTrace();
	        } catch (InvalidArgumentException e) {
	            e.printStackTrace();
	        }
	}
}
