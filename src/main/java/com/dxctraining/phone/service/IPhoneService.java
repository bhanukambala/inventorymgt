package com.dxctraining.phone.service;


import com.dxctraining.phone.entities.Phone;

public interface IPhoneService {
	Phone add(Phone phone);
	Phone findPhoneById(int id);
		 void remove(int id);

}
