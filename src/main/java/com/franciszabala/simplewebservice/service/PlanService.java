package com.franciszabala.simplewebservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciszabala.simplewebservice.exception.NoPlanFoundException;
import com.franciszabala.simplewebservice.model.Plan;
import com.franciszabala.simplewebservice.model.PlanSimple;
import com.franciszabala.simplewebservice.repository.PlanRepository;
import com.franciszabala.simplewebservice.util.PlanUtil;

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
	
	public Map<String, PlanSimple> getAllPlansMapped()  throws NoPlanFoundException {
		List<Plan> planList = this.planRepository.findAll();
		if (planList == null ) {
			return new HashMap<String, PlanSimple>();
		} else {
			Map <String, PlanSimple> map =  new HashMap<String, PlanSimple>();
			for(Plan p : planList) {
				map.put(p.getPlanId(), new PlanSimple(p));
			}
			
			
			return PlanUtil.sortByValue(map);
		}
		
	}
	
}
