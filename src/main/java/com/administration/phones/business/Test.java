package com.administration.phones.business;

import java.io.File;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.codec.digest.DigestUtils;

import com.administration.phones.entity.PhoneBean;

public class Test {
	public static void main (String args[]) {

	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	    PhoneBean blog = new PhoneBean();

	    Set<ConstraintViolation<PhoneBean>> constraintViolations = validator.validate(blog);
	    System.out.println(constraintViolations.isEmpty());
	    
	    for (ConstraintViolation<PhoneBean> c : constraintViolations) {
	    	System.out.println(c.getPropertyPath() + ":  " + c.getMessage());
	    }
		
	}
}
