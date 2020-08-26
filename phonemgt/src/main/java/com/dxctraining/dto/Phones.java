package com.dxctraining.dto;
import org.springframework.stereotype.Component;
import com.dxctraining.phone.entities.Phone;

	
	@Component
	public class Phones {

		public static PhoneReq phoneReq(Phone phone, int supplierId) {
			PhoneReq phoneReq = new PhoneReq(phone.getId(), phone.getName(), phone.getStoragesize());
			phoneReq.setSupplierId(supplierId);
			return phoneReq;
		}
	}

