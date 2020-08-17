package com.dxctraining.item.entites;

import javax.persistence.*;
import com.dxctraining.supplier.entities.Supplier;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="items")
public class Item {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private Supplier supplier;

	public Item(int id, String name,Supplier supplier) {
		this.id = id;
		this.name = name;
		this.supplier=supplier;
	}

	public Item() {

	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
