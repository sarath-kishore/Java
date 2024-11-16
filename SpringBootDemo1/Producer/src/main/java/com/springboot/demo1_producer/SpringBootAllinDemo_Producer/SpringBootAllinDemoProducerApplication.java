package com.springboot.demo1_producer.SpringBootAllinDemo_Producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springboot.demo1_producer.SpringBootAllinDemo_Producer.repository")
@EntityScan(basePackages = "com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model")
@ComponentScan(basePackages = "com.springboot.demo1_producer.SpringBootAllinDemo_Producer")
public class SpringBootAllinDemoProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAllinDemoProducerApplication.class, args);
	}

}
