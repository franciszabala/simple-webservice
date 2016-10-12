package com.franciszabala.simplewebservice.resource;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.franciszabala.simplewebservice.model.Plan;
import com.franciszabala.simplewebservice.resource.PlanResource;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanResource.class)
public class PlanResourceTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PlanResource planResource;
	
	@Test
	public void getPlanWhenRequestingShouldReturnMakeAndModel() throws Exception {
		given(this.planResource.getPlan("ult_small"))
				.willReturn(Plan.builder().planId("ult_small").sizeMb(1024).planName("Unlimited 1GB").build());
		this.mvc.perform(get("/plans/ult_small").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'plan_id':'ult_small','plan_name':'Unlimited 1GB'}"));
	}
	
	@Test
	public void getPlanWhenRequestingShouldReturnNotFound() throws Exception {
		given(this.planResource.getPlan("ult_small"))
		.willReturn(Plan.builder().planId("ult_small").sizeMb(1024).planName("Unlimited 1GB").build());
		this.mvc.perform(get("/plans/kjhsdfkjashdfakjshdfasdkjhf")).andExpect(status().isNotFound());
	}

}
