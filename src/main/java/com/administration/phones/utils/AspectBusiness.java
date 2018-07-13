package com.administration.phones.utils;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.administration.phones.entity.AspectPhone;
import com.administration.phones.entity.PhoneBean;
import com.administration.phones.exceptions.BadRequestException;
import com.administration.phones.exceptions.UnauthorizedException;

 
 

@Aspect
@Component
public class AspectBusiness {
	
	private static final Logger logger = Logger.getLogger(AspectBusiness.class.getName());
	private static final String VALUE_HASH = "SUPERWALLET";
	private static final String KEY_HASH = "DATA";
	private static final String VALUE_ERROR = "DATA not match";
	
	@Before("execution(* com.administration.phones.controller.*.*(..)) && @annotation(spanAnnotation)")
	public void before(final JoinPoint joinPoint, AspectPhone spanAnnotation) throws Exception {
		System.out.println("-->RegistryAspect");
        Signature signature = joinPoint.getSignature();
        MethodSignature mSignature = (MethodSignature) signature;
        
        validateHeader();
        PhoneBean bean = null;
        for (Object param : joinPoint.getArgs()) {
			if (param instanceof PhoneBean)
				bean = (PhoneBean) param;
		}
        validateRequest(bean);
       
        
        
	}

	private void validateRequest(PhoneBean bean) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	    PhoneBean blog = new PhoneBean();

	    Set<ConstraintViolation<PhoneBean>> constraintViolations = validator.validate(blog);
	    if (!constraintViolations.isEmpty());
	    	throw new BadRequestException();
	}

	private void validateHeader() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
        String data = request.getHeader(KEY_HASH);
        System.out.println("-->RegistryAspect" + data);
        if(StringUtils.isEmpty(data))
        	throw new UnauthorizedException();
        
        if(!(data.equalsIgnoreCase(DigestUtils.sha256Hex(VALUE_HASH))))
        	throw new UnauthorizedException(VALUE_ERROR);
	}
}
	