package com.xyz.orderservice.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.xyz.orderservice.entity.GuideOrder;
import com.xyz.orderservice.exception.*;
import com.xyz.orderservice.model.request.*;
import com.xyz.orderservice.model.response.CreateGuideOrderResponse;
import com.xyz.orderservice.repository.GuideOrderRepository;
import com.xyz.orderservice.service.GuideOrderService;

@Service
public class GuideOrderServiceImpl implements GuideOrderService {
	private static final Logger log = LoggerFactory.getLogger(GuideOrderServiceImpl.class);

	private final GuideOrderRepository repo;
	private final RestTemplate rest;
	private final String userServiceUrl;

	@Autowired
	public GuideOrderServiceImpl(
			GuideOrderRepository repo,
			RestTemplate rest,
			@Value("${user.service.base-url}") String userServiceUrl
	) {
		this.repo = repo;
		this.rest = rest;
		this.userServiceUrl = userServiceUrl;
	}

	@Override
	public CreateGuideOrderResponse createOrder(CreateGuideOrderRequest req) {
		require(req.getGuideSlug(),   "guideSlug");
		require(req.getUserId(),      "userId");
		require(req.getAmount(),      "amount");

		GuideOrder order = new GuideOrder();
		order.setGuideSlug(req.getGuideSlug());
		order.setUserId(req.getUserId());
		order.setOrderDate(LocalDate.now());
		order.setStatus("PENDING");
		order.setAmount(req.getAmount());

		repo.save(order);
		log.info("Created GuideOrder id={}", order.getId());
		return new CreateGuideOrderResponse(order.getId(), "Order placed successfully");
	}

	@Override
	public CreateGuideOrderResponse assignOrder(AssignGuideOrderRequest req) {
		require(req.getOrderId(),      "orderId");
		require(req.getAgentId(),      "agentId");
		require(req.getStatus(),       "status");

		GuideOrder order = repo.findById(req.getOrderId())
				.orElseThrow(() -> new OrderNotFoundException(req.getOrderId()));

		order.setAgentId(req.getAgentId());
		order.setStatus(req.getStatus());
		if ("DELIVERED".equalsIgnoreCase(req.getStatus())) {
			order.setDeliveredDate(LocalDate.now());
		}

		// Update agent availability
		try {
			rest.postForObject(
					userServiceUrl + "/users/" + req.getAgentId() + "/availability/" + req.getAgentAvailability(),
					null,
					Void.class
			);
		} catch (Exception e) {
			log.warn("Unable to update agent availability", e);
		}

		repo.save(order);
		log.info("Assigned GuideOrder id={} to agent={}", order.getId(), req.getAgentId());
		return new CreateGuideOrderResponse(order.getId(), "Order assigned successfully");
	}

	@Override
	public GuideOrder getOrderDetails(Long orderId) {
		require(orderId, "orderId");
		return repo.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException(orderId));
	}

	@Override
	public List<GuideOrder> listOrdersByUser(Long userId) {
		require(userId, "userId");
		return repo.findByUserId(userId);
	}

	@Override
	public List<GuideOrder> listOrdersByAgent(Long agentId) {
		require(agentId, "agentId");
		return repo.findByAgentId(agentId);
	}

	@Override
	public List<GuideOrder> listOrdersByStatus(String status) {
		require(status, "status");
		return repo.findByStatus(status);
	}

	private void require(Object val, String field) {
		if (val == null || (val instanceof String && ((String)val).trim().isEmpty())) {
			throw new BadRequestException(field + " is required");
		}
	}
}
