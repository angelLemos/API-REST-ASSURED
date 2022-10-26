package br.com.api.rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundoTest {

	@Test
	public void testOlaMundo() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me:80/ola");
		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
		Assert.assertTrue(response.statusCode() == 200);
		Assert.assertTrue("O status code deveria ser 200 ", response.statusCode() == 200);
		Assert.assertEquals(200, response.statusCode());
		
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
	}
	
	@Test
	public void outrasFormasRestAssured() {
		given() // Pré condições
		.when() //Ação
		   .get("http://restapi.wcaquino.me:80/ola")
		.then() // Assertivas/Validação
		   .statusCode(200);
	}
}
