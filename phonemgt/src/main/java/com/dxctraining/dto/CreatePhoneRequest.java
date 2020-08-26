package com.dxctraining.dto;


public class CreatePhoneRequest {

	private String name;

	private int storagesize;
	
	private int supplierid;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getStoragesize() {
		return storagesize;
	}

	public void setStoragesize(int storagesize) {
		this.storagesize = storagesize;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	
}
