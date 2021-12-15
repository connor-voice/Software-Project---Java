package com.bae.febe.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.febe.domain.Chocolate;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:chocolate-schema.sql",
		"classpath:chocolate-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ChocolateControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Chocolate testChocolate = new Chocolate("choc", "chocbrand", 2.00d, 500d, 1000);
		String testChocolateAsJSON = this.mapper.writeValueAsString(testChocolate);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testChocolateAsJSON);

		Chocolate testCreatedChocolate = new Chocolate(2, "choc", "chocbrand", 2.00d, 500d, 1000);
		String testCreatedChocolateAsJSON = this.mapper.writeValueAsString(testCreatedChocolate);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedChocolateAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetChocolates() throws Exception {
		RequestBuilder req = get("/getAll");

		List<Chocolate> testAllChocolates = List.of(new Chocolate(1, "Galaxy", "Mars", 2.00d, 1000d, 400));
		String testAllChocolatesAsJSON = this.mapper.writeValueAsString(testAllChocolates);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testAllChocolatesAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetChocolateById() throws Exception {
		Chocolate testChocolate = new Chocolate(1, "Galaxy", "Mars", 2.00d, 1000d, 400);
		String JSON = this.mapper.writeValueAsString(testChocolate);
		RequestBuilder req = get("/get/1");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(JSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdateChocolate() throws Exception {
		Chocolate testChocolate = new Chocolate("choc", "chocbrand", 2.00d, 500d, 1000);
		String testChocolateAsJSON = this.mapper.writeValueAsString(testChocolate);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testChocolateAsJSON);

		Chocolate testCreatedChocolate = new Chocolate(1, "choc", "chocbrand", 2.00d, 500d, 1000);
		String testCreatedChocolateAsJSON = this.mapper.writeValueAsString(testCreatedChocolate);
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testCreatedChocolateAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDeleteChocolate() throws Exception {
		this.mvc.perform(delete("/remove/1")).andExpect(status().isNoContent());
	}
}
