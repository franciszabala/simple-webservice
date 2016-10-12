package com.franciszabala.simplewebservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franciszabala.simplewebservice.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, String>{
	 Optional<Plan> findByPlanId(String planId);
}
