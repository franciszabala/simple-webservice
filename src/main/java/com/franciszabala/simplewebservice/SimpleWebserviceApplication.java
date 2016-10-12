package com.franciszabala.simplewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class SimpleWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebserviceApplication.class, args);
	}
	/** No need for this
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.serializationInclusion(JsonInclude.Include.NON_NULL);
	    builder.modulesToInstall(new Hibernate5Module());
	    return builder;
	}
	**/
}
