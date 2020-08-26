package com.dxctraining.phone.entities;

import javax.persistence.*;


@Entity
@Table(name="phones")
public class Phone {
	@Id
	@GeneratedValue
	private int id;
	
	private int storagesize;
	
	private String name;
	
	private int supplierid;
		
	public Phone( String name,int storagesize,int supplierid) {
		this.name=name;
		this.storagesize=storagesize;
		this.supplierid=supplierid;
		
	}
	public Phone() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
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
	public int hashCode() {
		return id;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		Phone that = (Phone) obj;
		return this.id== that.id;
	}
}
