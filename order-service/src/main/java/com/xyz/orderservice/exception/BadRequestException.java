package com.xyz.orderservice.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ServiceException {
	public BadRequestException(String message) {
		super(
				"INVALID_REQUEST",
				message,
				HttpStatus.BAD_REQUEST
		);
	}
}
