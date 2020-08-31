package com.dxctraining.supplier.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Supplier {

	@Id
	public String id;

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

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Supplier supplier = (Supplier) object;
		return Objects.equals(id, supplier.id);
	}
}
