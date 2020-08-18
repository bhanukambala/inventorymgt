package com.dxctraining.computer.entities;

import javax.persistence.*;

import com.dxctraining.item.entites.Item;
import com.dxctraining.supplier.entities.Supplier;




@Entity
@Table(name="computers")
public class Computer extends Item{
	
	
	
	private int disksize;
	
	public Computer( String name,Supplier supplier,int disksize) {
		super(name,supplier);
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
	
	
}
