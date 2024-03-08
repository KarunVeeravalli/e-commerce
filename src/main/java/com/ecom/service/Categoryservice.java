package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.CategoryException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Category;

public interface Categoryservice {

	Category addCategory(Category category, Integer userId, Principal user) throws UsersException, CategoryException;

	Category updateCategory(Category category, Integer categoryId, Integer userId, Principal user)
			throws UsersException, CategoryException;

	Category deleteCategory(Integer categoryId, Integer userId, Principal user)
			throws UsersException, CategoryException;

	Category getCategoryById(Integer categoryId, Integer userId, Principal user)
			throws UsersException, CategoryException;
	
	List<Category> getAllCategories(Integer userId,Principal user) throws UsersException,CategoryException;
	
	

}
