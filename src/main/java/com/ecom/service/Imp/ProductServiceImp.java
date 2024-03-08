package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.ProductException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Product;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.ProductRepo;
import com.ecom.service.ProductService;
import com.ecom.service.UsersService;


@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	UtilityHelper utilityHelper;
	
	@Autowired
	UsersService usersService;

	@Override
	public Product addProduct(Product product, Integer userId, Principal user) throws UsersException, ProductException {
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product, Integer productId, Integer userId, Principal user)
			throws UsersException, ProductException {
		Product oldProduct = getProductById(productId, userId, user);
		BeanUtils.copyProperties(product, oldProduct, utilityHelper.getNullPropertyNames(product));
		return productRepo.save(oldProduct);
	
	}

	@Override
	public Product getProductById(Integer productId, Integer userId, Principal user)
			throws UsersException, ProductException {
		
		return productRepo.findById(productId).get();
	}

	@Override
	public Product deleteProduct(Integer productId, Integer userId, Principal user)
			throws UsersException, ProductException {
		Product product = getProductById(productId, userId, user);
		productRepo.deleteById(productId);
		return product;
	}

	@Override
	public List<Product> getAllProducts(Integer userId, Principal user) throws UsersException, ProductException {
		return productRepo.findAll();
	}

}
