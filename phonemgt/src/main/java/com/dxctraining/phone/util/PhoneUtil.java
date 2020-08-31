package com.dxctraining.phone.util;
import org.springframework.stereotype.Component;

import com.dxctraining.phone.dto.PhoneDto;
import com.dxctraining.phone.entities.Phone;

	
	@Component
	public class PhoneUtil {

		public static PhoneDto phoneDto(Phone phone, int supplierId) {
			PhoneDto phoneReq = new PhoneDto(phone.getId(), phone.getName(), phone.getStoragesize());
			phoneReq.setSupplierId(supplierId);
			return phoneReq;
		}
	}

