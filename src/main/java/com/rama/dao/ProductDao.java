package com.rama.dao;

import java.util.List;

import com.rama.entity.Product;
import com.rama.entity.ProductCompositePK;


public interface ProductDao {

	boolean saveProduct(Product product);
	Product fetchProduct(ProductCompositePK pkId);
	List<Product> ProductList();
}
