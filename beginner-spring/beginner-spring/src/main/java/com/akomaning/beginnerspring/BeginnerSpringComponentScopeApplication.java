package com.akomaning.beginnerspring;

import com.akomaning.beginnerspring.scope.componentscan.ComponentPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.akomaning.beginnerspring.scope.componentscan")
public class BeginnerSpringComponentScopeApplication {
	private static  Logger LOGGER = LoggerFactory.getLogger(BeginnerSpringComponentScopeApplication.class);

	public static void main(String[] args) {
		//Adding @component annotation to the BinarySearchImplementation changes it to a Bean which is
		//automatically managed by spring Framework 👇👇
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());

		//NB: The Spring application Context (SpringApplication()) manages and maintains all the Beans
		ApplicationContext applicationContext = SpringApplication.run(BeginnerSpringComponentScopeApplication.class, args);
		ComponentPersonDAO componentPersonDAO = applicationContext.getBean(ComponentPersonDAO.class);

		LOGGER.info("{}", componentPersonDAO);

	}

}
