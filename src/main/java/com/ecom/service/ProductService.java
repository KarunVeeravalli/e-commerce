package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.ProductException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Product;

public interface ProductService {
	
	Product addProduct(Product product,Integer userId,Principal user) throws UsersException,ProductException;
	
	Product updateProduct(Product product,Integer productId,Integer userId,Principal user) throws UsersException,ProductException;
	
	Product getProductById(Integer productId,Integer userId,Principal user) throws UsersException,ProductException;
	
	Product deleteProduct(Integer productId,Integer userId,Principal user) throws UsersException,ProductException;
	
	List<Product> getAllProducts(Integer userId,Principal user) throws UsersException,ProductException;
	
	
}
