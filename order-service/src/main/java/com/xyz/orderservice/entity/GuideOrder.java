package com.xyz.orderservice.entity;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "guide_orders")
@Getter @Setter
public class GuideOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "guide_slug", nullable = false, length = 100)
	private String guideSlug;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Column(name = "agent_id")
	private Long agentId;

	@Column(name = "order_date", nullable = false)
	private LocalDate orderDate;

	@Column(name = "delivered_date")
	private LocalDate deliveredDate;

	@Column(nullable = false, length = 20)
	private String status;   // PENDING, SHIPPED, DELIVERED

	@Column(nullable = false)
	private Double amount;

	@Column(name = "tracking_id", length = 100)
	private String trackingId;
}
