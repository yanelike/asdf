package com.administration.phones.dao;

import com.administration.phones.entity.PhoneBean;

public interface PhoneDao {
	
	public void delete(PhoneBean phone);
	
	public void create(PhoneBean phone);
	
	public Iterable<PhoneBean> findAll();
	
	public PhoneBean findOne(Long id);
	
	public void update(PhoneBean phone);
	
	public PhoneBean findByImei(String imei);
	
}
