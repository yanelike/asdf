package com.administration.phones.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.administration.phones.dao.PhoneDao;
import com.administration.phones.entity.PhoneBean;
import com.administration.phones.exceptions.ResourceNotFoundException;

@Component
public class PhoneBOImpl implements PhoneBO{
	
	@Autowired
	PhoneDao phoneDao;
	
	@Override
	public PhoneBean create(PhoneBean phone) {
		phoneDao.create(phone);
		return findByImei(phone.getImei());
	}

	@Override
	public void delete(Long id) {
		phoneDao.delete(findOne(id));
	}

	@Override
	public Iterable<PhoneBean> findAll() {
		return phoneDao.findAll();
	}

	@Override
	public PhoneBean findOne(Long id) {
		PhoneBean phone = phoneDao.findOne(id);
		if (phone == null)
			new ResourceNotFoundException("Registry", "id", id);
		return phone;
	}

	@Override
	public PhoneBean update(PhoneBean phone, long id) {
		PhoneBean old = findOne(id);
		phone.setId(old.getId());
		phoneDao.update(phone);
		return phone;
	}

	@Override
	public PhoneBean findByImei(String imei) {
		PhoneBean phone = phoneDao.findByImei(imei);
		if (phone == null)
			new ResourceNotFoundException("Registry", "imei", imei);
		return phone;
	}

}
