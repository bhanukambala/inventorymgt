package com.dxctraining.dto;

import com.dxctraining.supplier.entities.Supplier;

public class CreatePhoneRequest {
	
	private String name;
	private Supplier supplier;
	private int storagesize;
	private String password;
	public String getName() {
		return name;
	}
	
	public int getStoragesize() {
		return storagesize;
	}

	public void setStoragesize(int storagesize) {
		this.storagesize = storagesize;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
