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

//	docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_USER=sarath -e MYSQL_PASSWORD=sarath -e MYSQL_DATABASE=sarathdb -v /Users/sarathkishore/Documents/Docker/sb_demo1/mysql-data:/var/lib/mysql -p 3306:3306 mysql/mysql-server:latest

// for postman REST api's, first login via / sending username, password and csrf value from the html form as form data
// then use the api/orders/csrf to get csrf value for the current session.
// then use GET /api/orders to get all orders.
// use POST /api/orders and "name" with product name as json and csrf from above as X-CSRF-TOKEN in the header to add product.
// no need for sessionID here because we are using the login page and form-data to login and authenticate, hence session ID gets stored in postman just like in a browser
// here the POST requests won't work without logging in using /login because, this security config seems to need session tokens to all POST requests.
// hence simple passing of username and password using Basic Auth and using csrf token in header is not enough.
// this is because in the security config, this api/orders is not listed to be permitted to work without authorisation in the 'authorizeHttpRequests()'

// when session auth is enabled, it's enough if the LoginController.login() method is executed, i.e via /login api, because in this method we are explicitly setting the session data,
// hence for every other subsequent api calls, session token is used for auth, no need to pass credentials via basic auth in postman.
// If the session auth is disabled, even if the /login api is executed, for every api call, credentials need to be passed via basic auth. here is where we can use JWT to solve. session auth also solves this same issue, but JWT has its own pros and cons.