package com.carlosamaral.demo

import com.carlosamaral.demo.controllers.FooController
import com.carlosamaral.demo.models.FooModel
import com.carlosamaral.demo.services.FooService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import org.springframework.test.web.servlet.MockMvc


@SpringBootTest
class FooControllerTests {
//	@Test
//	public void givenEmployees_whenGetEmployees_thenStatus200()
//	throws Exception {
//
//		createTestEmployee("bob");
//
//		mvc.perform(get("/api/employees")
//			.contentType(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(content()
//				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//			.andExpect(jsonPath("$[0].name", is("bob")));
//	}

}