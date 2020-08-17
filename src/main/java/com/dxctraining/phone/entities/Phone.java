package com.dxctraining.phone.entities;

import javax.persistence.*;

import com.dxctraining.item.entites.Item;
import com.dxctraining.supplier.entities.Supplier;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="phones")
public class Phone extends Item {
	
	@Id
	@GeneratedValue
	private int serialnum;
	private int storagesize;
	
	public Phone(int id, String name,Supplier supplier,int storagesize,int serialnum) {
		super( id,name,supplier);
		this.storagesize=storagesize;
		this.serialnum=serialnum;
	}
	public Phone() {
		
	}
	public int getStoragesize() {
		return storagesize;
	}
	public void setStoragesize(int storagesize) {
		this.storagesize = storagesize;
	}
	public int getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(int serialnum) {
		this.serialnum = serialnum;
	}
	@Override
	public int hashCode() {
		return serialnum;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Phone that = (Phone) object;
		return serialnum == that.serialnum;
	}
}
