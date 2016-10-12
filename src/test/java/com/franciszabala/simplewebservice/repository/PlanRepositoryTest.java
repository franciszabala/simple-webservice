package com.franciszabala.simplewebservice.repository;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.franciszabala.simplewebservice.model.Plan;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link UserRepository}.
 *
 * @author Phillip Webb
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanRepositoryTest {


	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PlanRepository planRepository;

	@Test
	public void findByPlanIdShouldReturnPlan() throws Exception {
		
		this.entityManager.persist(Plan.builder().planId("plan_id")._4g(true).infoUrl("http://localhost").build());
		Plan plan = this.planRepository.findOne("plan_id");
		
		assertThat(plan.getPlanId()).isEqualTo("plan_id");
		assertThat(plan.is4g()).isEqualTo(true);
		assertThat(plan.getInfoUrl()).isEqualTo("http://localhost");
	}

	@Test
	public void findByPlanIdWhenNoPlanShouldReturnNull() throws Exception {
		this.entityManager.persist(Plan.builder().planId("plan_id")._4g(true).infoUrl("http://localhost").build());
		Plan plan = this.planRepository.findOne("plan_not_id");
		assertThat(plan).isNull();
	}

}
