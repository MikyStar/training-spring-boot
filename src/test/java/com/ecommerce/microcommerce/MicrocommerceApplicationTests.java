package com.ecommerce.microcommerce;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ecommerce.microcommerce.web.controller.ProductController;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicrocommerceApplicationTests {

	MockMvc mockMvc;
	private WebApplicationContext context;
	ProductController productController;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(this.productController).build();
	}
	
	@Test
	public void contextLoads() {
	}

}
