package com.xyz.orderservice.model.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter @Setter
public class AssignGuideOrderRequest {
	@NotNull private Long orderId;
	@NotNull private Long agentId;
	@NotBlank private String status;
	private String agentAvailability; // e.g. AVAILABLE or BUSY
}
