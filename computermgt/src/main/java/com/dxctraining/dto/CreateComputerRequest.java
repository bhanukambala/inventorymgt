package com.dxctraining.dto;

public class CreateComputerRequest {
	
	private String name;
	private int disksize;
	private int supplierid;
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDisksize() {
		return disksize;
	}

	public void setDisksize(int disksize) {
		this.disksize = disksize;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

		

}
