package com.xyz.orderservice.service;

import java.util.List;
import com.xyz.orderservice.entity.GuideOrder;
import com.xyz.orderservice.model.request.AssignGuideOrderRequest;
import com.xyz.orderservice.model.request.CreateGuideOrderRequest;
import com.xyz.orderservice.model.response.CreateGuideOrderResponse;

public interface GuideOrderService {
	CreateGuideOrderResponse createOrder(CreateGuideOrderRequest request);
	CreateGuideOrderResponse assignOrder(AssignGuideOrderRequest request);
	GuideOrder getOrderDetails(Long orderId);
	List<GuideOrder> listOrdersByUser(Long userId);
	List<GuideOrder> listOrdersByAgent(Long agentId);
	List<GuideOrder> listOrdersByStatus(String status);
}
