package com.dxctraining.dto;

import com.dxctraining.supplier.entities.Supplier;

public class CreateComputerRequest {
	
	private String name;
	private Supplier supplier;
	private int disksize;
	private String password;
	public String getName() {
		return name;
	}
	
	public int getDisksize() {
		return disksize;
	}

	public void setDisksize(int disksize) {
		this.disksize = disksize;
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
