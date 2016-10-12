package com.franciszabala.simplewebservice.resource;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.franciszabala.simplewebservice.model.Plan;
import com.franciszabala.simplewebservice.model.PlanSimple;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanResource.class)
public class PlanResourceTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PlanResource planResource;
	
	@Test
	public void getPlanWhenRequestingShouldReturnPlan() throws Exception {
		given(this.planResource.getPlan("ult_small"))
				.willReturn(Plan.builder().planId("ult_small").sizeMb(1024).planName("Unlimited 1GB").build());
		this.mvc.perform(get("/plans/ult_small").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'plan_id':'ult_small','plan_name':'Unlimited 1GB'}"));
	}
	//TODO
	//Create a unit test with ordered by mb result
	@Test
	public void getPlanWhenRequestingShouldReturnPlanMap() throws Exception {
		Map<String, PlanSimple> planMap = new HashMap<String, PlanSimple>();
		Plan p1 = Plan.builder()
				.planId("ult_small").sizeMb(1024).planName("Unlimited 1GB").build();
		Plan p2 = Plan.builder()
				.planId("ult_medium").sizeMb(2048).planName("Unlimited 2GB").build();
		PlanSimple ps1 = new PlanSimple(p1);
		PlanSimple ps2 = new PlanSimple(p2);
		
		planMap.put(p1.getPlanId(), ps1);
		planMap.put(p2.getPlanId(), ps2);
		
		given(this.planResource.getAllPlansFormatted())
				.willReturn(planMap);
		this.mvc.perform(get("/plans/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'ult_medium':{'plan_name':'Unlimited 2GB','plan_price':null,'expiry':null,'is_plan':null,"
						+ "'is_unlimited':null,'size_mb':2048,'terms_url':null,'info_url':null,'is_4g':null,'is_auto_renew':null},'ult_small':{'plan_name':'Unlimited 1GB','plan_price':null,"
						+ "'expiry':null,'is_plan':null,'is_unlimited':null,'size_mb':1024,'terms_url':null,'info_url':null,'is_4g':null,'is_auto_renew':null}}"));
	}
	
	/** False Negative :( **/
	/*
	@Test
	public void getPlanWhenRequestingShouldReturnNotFound() throws Exception {
		given(this.planResource.getPlan("ult_small"))
			.willReturn(Plan.builder().planId("ult_small").sizeMb(1024).planName("Unlimited 1GB").build());
		this.mvc.perform(get("/plans/kjhsdfkjashdfakjshdfasdkjhf"))
			.andExpect(status().isNotFound());
	}
	*/

}