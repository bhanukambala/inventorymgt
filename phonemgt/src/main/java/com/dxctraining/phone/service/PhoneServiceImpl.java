package com.dxctraining.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.phone.dao.IPhoneDao;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.exceptions.InvalidArgumentException;


@Transactional
@Service
public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	private IPhoneDao dao;

	@Override
	public Phone save(Phone phone) {
		display(phone);
		phone = dao.save(phone);
		return phone;
	}

	public void display(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is null");
		}

	}

	@Override
	public Phone findPhoneById(int id) {
		Phone phone= dao.findPhoneById(id);
		return phone;
	}
	 @Override
	    public List<Phone> phoneList() {
	        List<Phone>result=dao.phoneList();
	        return result;
	    }
	 @Override
		public List<Phone> findPhoneBySupplier(int supplierId){
			List<Phone>list=dao.findPhoneBySupplier(supplierId);
			return list;
		}
	@Override
	public void remove(int id) {
		dao.remove(id);

	}

}
