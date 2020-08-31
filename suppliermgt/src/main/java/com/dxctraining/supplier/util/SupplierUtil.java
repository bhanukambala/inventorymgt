package com.dxctraining.supplier.util;

import org.springframework.stereotype.Component;

import com.dxctraining.supplier.dto.SupplierDto;
import com.dxctraining.supplier.entities.Supplier;

@Component
	public class SupplierUtil {

		public SupplierDto supplierDto(Supplier supplier) {
			SupplierDto dto = new SupplierDto(supplier.getId(), supplier.getName(), supplier.getPassword());
			return dto;
		}
}
