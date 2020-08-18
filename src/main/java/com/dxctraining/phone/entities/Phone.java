package com.dxctraining.phone.entities;

import javax.persistence.*;

import com.dxctraining.item.entites.Item;
import com.dxctraining.supplier.entities.Supplier;


@Entity
@Table(name="phones")
public class Phone extends Item {
	
	
	private int storagesize;
	
	public Phone( String name,Supplier supplier,int storagesize) {
		super(name,supplier);
		this.storagesize=storagesize;
		
	}
	public Phone() {
		
	}
	public int getStoragesize() {
		return storagesize;
	}
	public void setStoragesize(int storagesize) {
		this.storagesize = storagesize;
	}
		@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Phone that = (Phone) object;
		return getId() == that.getId();
	}
}
