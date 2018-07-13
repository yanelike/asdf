package com.administration.phones.business;

import com.administration.phones.entity.PhoneBean;

public interface PhoneBO { 
		
		public PhoneBean create(PhoneBean phone);
		
		public void delete(Long id);
		
		public Iterable<PhoneBean> findAll();
		
		public PhoneBean findOne(Long id);
		
		public PhoneBean update(PhoneBean phone, long id);
		
		public PhoneBean findByImei(String imei);
		
}