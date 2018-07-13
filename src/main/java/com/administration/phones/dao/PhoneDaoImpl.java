package com.administration.phones.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.administration.phones.entity.PhoneBean;


@Repository
public class PhoneDaoImpl implements PhoneDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void delete(PhoneBean phone) {
		mongoTemplate.remove(phone);
	}

	@Override
	public void create(PhoneBean phone) {
		mongoTemplate.insert(phone); 
	}

	@Override
	public Iterable<PhoneBean> findAll() {
		return mongoTemplate.findAll(PhoneBean.class);
	}

	@Override
	public PhoneBean findOne(Long id) {
		Query query = new Query(Criteria.where("_id").is(id));
		PhoneBean result = mongoTemplate.findOne(query, PhoneBean.class);
		return result;
	}

	@Override
	public void update(PhoneBean phone) {
		mongoTemplate.save(phone);
		
	}

	@Override
	public PhoneBean findByImei(String imei) {
		Query query = new Query(Criteria.where("imei").is(imei));
		PhoneBean result = mongoTemplate.findOne(query, PhoneBean.class);
		return result;
	}

}
