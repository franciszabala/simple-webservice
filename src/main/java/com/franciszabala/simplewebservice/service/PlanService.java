package com.franciszabala.simplewebservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciszabala.simplewebservice.exception.NoPlanFoundException;
import com.franciszabala.simplewebservice.model.Plan;
import com.franciszabala.simplewebservice.repository.PlanRepository;

@Service
public class PlanService {
	private PlanRepository planRepository;

	@Autowired
	public PlanService(PlanRepository planRepository) {
		super();
		this.planRepository = planRepository;
	}
	
	public Plan getPlanByPlanId(String planId) throws NoPlanFoundException {
		Optional<Plan> plan = this.planRepository.findByPlanId(planId);
		if (plan.isPresent()) {
			return plan.get();
		} else {
			throw new NoPlanFoundException("No plans found");
		}
	}
	
	public List<Plan> getAllPlans() throws NoPlanFoundException {
		List<Plan> planList = this.planRepository.findAll();
		if (planList == null ) {
			return new ArrayList<Plan>();
		} else {
			return planList;
		}
		
	}
	
}
