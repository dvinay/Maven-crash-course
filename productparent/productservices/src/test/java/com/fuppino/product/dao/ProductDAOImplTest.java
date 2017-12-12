package com.fuppino.product.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fuppino.product.dto.Product;

public class ProductDAOImplTest {

	@Test
	public void checkCreate() {
		ProductDAO productDAO = new ProductDAOImpl();
		Product product = new Product(1,"Sample product", "Sample description", 100);
		productDAO.create(product);
		
		Product result = productDAO.read(product.getId());
		
		assertNotNull(result);
		assertEquals("Sample product",result.getName());
		
	}

}
