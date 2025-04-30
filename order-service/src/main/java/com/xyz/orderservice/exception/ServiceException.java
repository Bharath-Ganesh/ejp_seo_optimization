package com.xyz.orderservice.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
	private final String errorCode;
	private final HttpStatus httpStatus;

	public ServiceException(String errorCode, String message, HttpStatus status) {
		super(message);
		this.errorCode   = errorCode;
		this.httpStatus  = status;
	}

	public ServiceException(String errorCode, String message, HttpStatus status, Throwable cause) {
		super(message, cause);
		this.errorCode   = errorCode;
		this.httpStatus  = status;
	}
}
