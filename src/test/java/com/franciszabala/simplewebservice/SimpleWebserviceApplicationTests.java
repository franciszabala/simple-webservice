package com.franciszabala.simplewebservice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.franciszabala.simplewebservice.repository.PlanRepositoryTest;
import com.franciszabala.simplewebservice.resource.PlanResourceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlanRepositoryTest.class, 
        PlanResourceTest.class  
})
public class SimpleWebserviceApplicationTests {
	
}
