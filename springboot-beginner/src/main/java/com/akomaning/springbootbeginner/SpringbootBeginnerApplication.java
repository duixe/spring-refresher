package com.akomaning.springbootbeginner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootBeginnerApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringbootBeginnerApplication.class, args);

		for(String name: applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
