package com.dxctraining.supplier.entities;

import javax.persistence.*;


@Entity
@Table(name="suppliers")
public class Supplier {

	@Id
	@GeneratedValue
	public int id;

	private String name;
	
	private String password;

	public Supplier(String name,String password) {
		this.name = name;
		this.password=password;
	}

	public Supplier() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Supplier that = (Supplier) object;
		return id == that.id;
	}
}
