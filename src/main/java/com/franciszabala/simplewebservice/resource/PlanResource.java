package com.franciszabala.simplewebservice.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.franciszabala.simplewebservice.exception.NoPlanFoundException;
import com.franciszabala.simplewebservice.model.Plan;
import com.franciszabala.simplewebservice.service.PlanService;


@RestController
@RequestMapping("plans/")
public class PlanResource {

	private PlanService planService;

	@Autowired
	public PlanResource(PlanService planService) {
		this.planService = planService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="all", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Plan> getAllPlans() throws NoPlanFoundException {
		return this.planService.getAllPlans();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="{planId}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Plan getPlan(@PathVariable String planId) throws NoPlanFoundException {
		Plan plan = this.planService.getPlanByPlanId(planId);
		return plan;
		
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NoPlanFoundException.class)  
    public void nfeHandler(HttpServletResponse response, NoPlanFoundException nrfe) throws IOException{  
    	response.sendError(HttpStatus.BAD_REQUEST.value(), nrfe.getMessage());
    }
	
}
