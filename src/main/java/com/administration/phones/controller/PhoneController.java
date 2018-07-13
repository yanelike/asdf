package com.administration.phones.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.administration.phones.business.PhoneBO;
import com.administration.phones.entity.AspectPhone;
import com.administration.phones.entity.PhoneBean;
import com.administration.phones.entity.ResponseTO;


@RestController
@RequestMapping("/v1/phones")
public class PhoneController {
	
	@Autowired
	PhoneBO phoneBO;
	
	@AspectPhone
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<PhoneBean> findAll() throws Exception {
        return phoneBO.findAll();
    }
    
	@AspectPhone
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneBean findOne(@PathVariable("id") Long id) throws Exception {
    	return phoneBO.findOne(id);
    }
	
    @AspectPhone
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody PhoneBean resource) {
    	
    	ResponseTO response = new ResponseTO();
    	try {
    		phoneBO.create(resource);
    		response.setCode("0");
    		response.setMessage("Success");
		} catch (Exception e) {
			response.setCode("-1");
    		response.setMessage("Fail");
    		return new ResponseEntity<>(response,HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    
    @AspectPhone
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		phoneBO.delete(id);
    	ResponseTO response = new ResponseTO();
		response.setCode("0");
		response.setMessage("Success");
		return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
    }
    
    @AspectPhone
    @RequestMapping(value = "/{imei}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PhoneBean findByImei(@PathVariable("imei") String imei) throws Exception {
    	return phoneBO.findByImei(imei);
    }
    
    @AspectPhone
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PhoneBean> update(@PathVariable("id") long id, @RequestBody PhoneBean phone) {
    	PhoneBean newPhone = phoneBO.update(phone, id);
        return new ResponseEntity<PhoneBean>(newPhone, HttpStatus.OK);
    }
    
}