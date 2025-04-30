package com.xyz.orderservice.controller;

import com.xyz.orderservice.entity.GuideOrder;
import com.xyz.orderservice.model.request.AssignGuideOrderRequest;
import com.xyz.orderservice.model.request.CreateGuideOrderRequest;
import com.xyz.orderservice.model.response.CreateGuideOrderResponse;
import com.xyz.orderservice.service.GuideOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class GuideOrderController {

	@Autowired private GuideOrderService service;

	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<CreateGuideOrderResponse> create(@RequestBody CreateGuideOrderRequest req) {
		return ResponseEntity.ok(service.createOrder(req));
	}

	@PostMapping("/assign")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<CreateGuideOrderResponse> assign(@RequestBody AssignGuideOrderRequest req) {
		return ResponseEntity.ok(service.assignOrder(req));
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public ResponseEntity<GuideOrder> getDetails(@PathVariable Long id) {
		return ResponseEntity.ok(service.getOrderDetails(id));
	}

	@GetMapping("/user/{userId}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<GuideOrder>> listByUser(@PathVariable Long userId) {
		return ResponseEntity.ok(service.listOrdersByUser(userId));
	}

	@GetMapping("/agent/{agentId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<GuideOrder>> listByAgent(@PathVariable Long agentId) {
		return ResponseEntity.ok(service.listOrdersByAgent(agentId));
	}

	@GetMapping("/status/{status}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<GuideOrder>> listByStatus(@PathVariable String status) {
		return ResponseEntity.ok(service.listOrdersByStatus(status));
	}
}
