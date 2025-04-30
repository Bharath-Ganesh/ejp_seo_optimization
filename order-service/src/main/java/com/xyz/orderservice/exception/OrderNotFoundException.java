package com.xyz.orderservice.exception;

import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends ServiceException {
	public OrderNotFoundException(Long orderId) {
		super(
				"ORDER_NOT_FOUND",
				"Order not found: " + orderId,
				HttpStatus.NOT_FOUND
		);
	}
}
