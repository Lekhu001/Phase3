package com.assignment.Phase3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssignmentPost {

	protected static Logger Resultlog = LogManager.getLogger(AssignmentPost.class.getName());

	@Test
	public void get() {

		Resultlog.info("All the info show");
		String payload = "{\"name\": \"morpheus\", \"job\": \"leader\"}";
		RestAssured.baseURI = "https://reqres.in";

		Response response = RestAssured.given().log().all().accept(ContentType.JSON).contentType(ContentType.JSON)
				.body(payload).when().post("/api/users");

		Resultlog.debug(response.getStatusCode());

		Resultlog.debug(response.getTime());
		Resultlog.debug(response.body().asPrettyString());

	}
}
