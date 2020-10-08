package org.acme.web;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResourceTest {

	@Test
	public void testHelloDefault() {
		given()
			.when().get("/hello")
			.then()
			.statusCode(200)
			.body(is("Hello, quarkus!"));
	}

	@Test
	public void testHello() {
		given()
			.when().get("/hello/world")
			.then()
			.statusCode(200)
			.body(is("Hello, world!"));
	}

}
