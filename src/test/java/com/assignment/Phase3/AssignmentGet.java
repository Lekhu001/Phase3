package com.assignment.Phase3;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AssignmentGet {
	protected static Logger Resultlog = LogManager.getLogger(AssignmentGet.class.getName());

	@Test
	public void get() {
		Resultlog.info("All the info show");
		RestAssured.baseURI = "https://reqres.in";

		RestAssured.given().log().all().accept(ContentType.JSON).when().get("/api/users?page=2").then().statusCode(200)
				.assertThat().header("Connection", equalTo("keep-alive"))
				.body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).time(lessThan(5000L)).log().all();
	}

}
