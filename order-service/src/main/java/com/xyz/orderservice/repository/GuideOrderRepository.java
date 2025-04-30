package com.xyz.orderservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.xyz.orderservice.entity.GuideOrder;

public interface GuideOrderRepository extends JpaRepository<GuideOrder, Long> {
	List<GuideOrder> findByUserId(Long userId);
	List<GuideOrder> findByAgentId(Long agentId);
	List<GuideOrder> findByStatus(String status);
}
