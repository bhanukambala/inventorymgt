package com.dxctraining.supplier.entities;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="suppliers")
public class Supplier {

	@Id
	@GeneratedValue
	public int id;

	private String name;

	public Supplier(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Supplier() {

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
