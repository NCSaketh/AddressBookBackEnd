package com.bl.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AddressBookAppApplication {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AddressBookAppApplication.class);
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);
		log.info("AddressBook App Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("AddressBook DB User is {} ",
				context.getEnvironment().getProperty("spring.datasource.username"));
	}
}
