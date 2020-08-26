package com.dxctraining.dto;

public class ComputerReq {
	private int id;

	private String name;

	private int diskSize;

	private int supplierId;


	public ComputerReq() {
	}

	public ComputerReq(int id, String name, int diskSize) {
		this.id = id;
		this.name = name;
		this.diskSize = diskSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

}
