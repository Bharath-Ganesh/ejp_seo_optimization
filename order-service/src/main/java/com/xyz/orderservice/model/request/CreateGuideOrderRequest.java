package com.xyz.orderservice.model.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter @Setter
public class CreateGuideOrderRequest {
	@NotBlank private String guideSlug;
	@NotNull private Long userId;
	@NotNull private Double amount;
}
