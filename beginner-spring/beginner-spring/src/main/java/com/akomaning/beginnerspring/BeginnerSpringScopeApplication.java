package com.akomaning.beginnerspring;

import com.akomaning.beginnerspring.basic.BinarySearchImpl;
import com.akomaning.beginnerspring.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeginnerSpringScopeApplication {
	private static  Logger LOGGER = LoggerFactory.getLogger(BeginnerSpringScopeApplication.class);

	public static void main(String[] args) {
		//Adding @component annotation to the BinarySearchImplementation changes it to a Bean which is
		//automatically managed by spring Framework 👇👇
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());

		//NB: The Spring application Context (SpringApplication()) manages and maintains all the Beans
		ApplicationContext applicationContext = SpringApplication.run(BeginnerSpringScopeApplication.class, args);
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);

		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());

		LOGGER.info("{}", personDAO2);
		LOGGER.info("{}", personDAO2.getJdbcConnection());

	}

}
