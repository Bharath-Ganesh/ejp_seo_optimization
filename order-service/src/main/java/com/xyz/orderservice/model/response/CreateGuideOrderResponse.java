package com.xyz.orderservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class CreateGuideOrderResponse {
	private Long orderId;
	private String message;
}
