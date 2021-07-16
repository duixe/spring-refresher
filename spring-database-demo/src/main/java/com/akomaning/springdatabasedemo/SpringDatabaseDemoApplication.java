package com.akomaning.springdatabasedemo;

import com.akomaning.springdatabasedemo.entity.Person;
import com.akomaning.springdatabasedemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDatabaseDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO personJdbcDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person newPerson = new Person(10005, "Adanko", "Achimota", new Date());
		Person newPersonObject = new Person(10003, "Joshua", "Israel", new Date());

		logger.info("All Users -> {}",
				personJdbcDAO.getAll());
		logger.info("User id 10001 -> {}", personJdbcDAO.getById(10001));
		logger.info("Deleted user with id 10002 -> No of Rows affected is {}", personJdbcDAO.deleteById(10002));
//		logger.info("Adding 10005 -> {}", personJdbcDAO.insert(newPerson));
		logger.info("Adding 10003 -> {}", personJdbcDAO.update(newPersonObject));
	}
}
