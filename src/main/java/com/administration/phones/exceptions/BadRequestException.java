package com.administration.phones.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class BadRequestException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1109429374203212362L;
	private static final String UNAUTHORIZED = "Ops Bad Request";
	private static final String SPACE = " ";
	private String message; 
	
    public BadRequestException() {
        super(String.format(UNAUTHORIZED));
    }
    
    public BadRequestException( String message) {
        super(String.format(UNAUTHORIZED + SPACE + message ));
        this.message = message;  
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}