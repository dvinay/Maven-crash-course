package com.fuppino.product.bo;

import com.fuppino.product.dto.Product;

public interface ProductBO {
	void create(Product product);
	Product findProduct(int id);
}
