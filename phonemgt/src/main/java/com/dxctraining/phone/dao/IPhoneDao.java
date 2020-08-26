package com.dxctraining.phone.dao;

import java.util.List;
import com.dxctraining.phone.entities.Phone;

public interface IPhoneDao {
	Phone add(Phone phone);
		 void remove(int id);
		Phone findPhoneById(int id);
		List<Phone> phoneList();
		List<Phone> findPhoneBySupplier(int supplierId);
}
