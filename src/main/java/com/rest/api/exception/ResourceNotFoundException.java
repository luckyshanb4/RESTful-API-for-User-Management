package com.rest.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resorceName;
	private String fieldName;
	private Object fieldValue;
	
	public ResourceNotFoundException(String resorceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'",resorceName,fieldName,fieldValue));
		this.resorceName = resorceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResorceName() {
		return resorceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}


}
