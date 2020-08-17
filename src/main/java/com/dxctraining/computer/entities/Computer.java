package com.dxctraining.computer.entities;

import javax.persistence.*;

import com.dxctraining.item.entites.Item;
import com.dxctraining.supplier.entities.Supplier;



@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="computers")
public class Computer extends Item{
	
	@Id
	@GeneratedValue
	private int serialnum;
	private int disksize;
	
	public Computer(int id, String name,Supplier supplier,int disksize,int serialnum) {
		super(id,name,supplier);
		this.serialnum=serialnum;
		this.disksize=disksize;
	}
	public Computer() {
		
	}
	public int getDisksize() {
		return disksize;
	}
	public void setDisksize(int disksize) {
		this.disksize = disksize;
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
		Computer that = (Computer) object;
		return serialnum == that.serialnum;
	}
}
