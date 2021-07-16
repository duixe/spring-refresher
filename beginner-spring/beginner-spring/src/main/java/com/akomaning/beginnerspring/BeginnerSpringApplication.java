package com.akomaning.beginnerspring;

import com.akomaning.beginnerspring.basic.BinarySearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeginnerSpringApplication {

	public static void main(String[] args) {
		//Adding @component annotation to the BinarySearchImplementation changes it to a Bean which is
		//automatically managed by spring Framework 👇👇
//		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());

		//NB: The Spring application Context (SpringApplication()) manages and maintains all the Beans
		ApplicationContext applicationContext = SpringApplication.run(BeginnerSpringApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] {1, 4, 3, 6}, 3);
		System.out.println(result);

//		SpringApplication.run(BeginnerSpringApplication.class, args);
	}

}
