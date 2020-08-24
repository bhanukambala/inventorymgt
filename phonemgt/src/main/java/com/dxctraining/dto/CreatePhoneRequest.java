package com.dxctraining.dto;


public class CreatePhoneRequest {

	private String name;

	private int storagesize;

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

}
