package com.ecommerce.microcommerce;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.controller.ProductController;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicrocommerceApplicationTests {

	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	ProductDao productDao;
	
	ProductController productController;
	
	//////////////////////////////////////////////////////////////////////////////////
	
	private final int DEFAULT_PRODUCTS_LENGTH = 3;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup( context ).build();
	}
	
	@Test
	/** @see https://blog.zenika.com/2016/11/25/spring-mvc-test-dans-un-contexte-securise/ */
	public void testProductID() throws Exception 
	{
		// ArrayList<Product> products = ( ArrayList<Product> ) productDao.findAll();
		
		this.mockMvc.perform( get( "/Produits/{id}", 1 ).accept( MediaType.APPLICATION_JSON ) )
			.andExpect( status().isOk() )
			.andExpect( jsonPath( "$.nom" ).value( "Ordinateur portable" ) );
	}

	@Test
	/** @see https://blog.zenika.com/2016/11/25/spring-mvc-test-dans-un-contexte-securise/ */
	public void testAddProduct() throws Exception 
	{
		// ArrayList<Product> products = ( ArrayList<Product> ) productDao.findAll();
	}
	
	@Test
	public void testGetAllProducts() throws Exception 
	{
		// ArrayList<Product> products = ( ArrayList<Product> ) productDao.findAll();
		
		this.mockMvc.perform( get( "/Produits" ).accept( MediaType.APPLICATION_JSON ) )
			.andExpect( status().isOk() )
			.andExpect( jsonPath( "$", hasSize( DEFAULT_PRODUCTS_LENGTH ) ) );
	}
}
