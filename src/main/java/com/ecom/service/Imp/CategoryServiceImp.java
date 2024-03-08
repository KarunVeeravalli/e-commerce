package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.CategoryException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Category;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.CategoryRepo;
import com.ecom.service.Categoryservice;
import com.ecom.service.UsersService;


@Service
public class CategoryServiceImp implements Categoryservice{
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	UtilityHelper utilityHelper;

	@Override
	public Category addCategory(Category category, Integer userId, Principal user)
			throws UsersException, CategoryException {
		return categoryRepo.save(category);
		
	}

	@Override
	public Category updateCategory(Category category, Integer categoryId, Integer userId, Principal user)
			throws UsersException, CategoryException {
		Category oldCategory = getCategoryById(categoryId, userId, user);
		BeanUtils.copyProperties(category, oldCategory, utilityHelper.getNullPropertyNames(category));
		return categoryRepo.save(oldCategory);
	}

	@Override
	public Category deleteCategory(Integer categoryId, Integer userId, Principal user)
			throws UsersException, CategoryException {
		Category category = getCategoryById(categoryId, userId, user);
		categoryRepo.deleteById(categoryId);
		return category;
	}

	@Override
	public Category getCategoryById(Integer categoryId, Integer userId, Principal user)
			throws UsersException, CategoryException {
		return categoryRepo.findById(categoryId).get();
	}

	@Override
	public List<Category> getAllCategories(Integer userId, Principal user) throws UsersException, CategoryException {
		return categoryRepo.findAllByUsersId(userId);
	}

}
