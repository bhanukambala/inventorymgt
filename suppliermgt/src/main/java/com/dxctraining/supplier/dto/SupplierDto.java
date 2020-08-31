package com.dxctraining.supplier.dto;

public class SupplierDto {
		private String id;
		private String name;
		private String password;

		public SupplierDto(String id, String name, String password) {
			this.id=id;
			this.name=name;
			this.password=password;
		}
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
}
