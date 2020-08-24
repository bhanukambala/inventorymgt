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
		
	public Phone( String name,int storagesize) {
		this.name=name;
		this.storagesize=storagesize;
		
	}
	public Phone() {
		
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
