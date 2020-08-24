package com.dxctraining.computer.entities;

import javax.persistence.*;


@Entity
@Table(name="computers")
public class Computer {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int disksize;
	
	private String name;
		
	public Computer( String name,int disksize) {
		this.name=name;
		this.disksize=disksize;
	}
	public Computer() {
		
	}
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		Computer that = (Computer) obj;
		return this.id== that.id;
	}
}
