package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.InventoryException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Inventory;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.InventoryRepo;
import com.ecom.service.InventoryService;
import com.ecom.service.UsersService;


@Service
public class InventoryServiceImp implements InventoryService{
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	InventoryRepo inventoryRepo;
	
	@Autowired
	UtilityHelper utilityHelper;

	@Override
	public Inventory addItemToInventory(Integer userId, Inventory inventory, Principal user)
			throws InventoryException, UsersException {
		
		return inventoryRepo.save(inventory);
		
	}

	@Override
	public Inventory updateInventory(Integer inventoryId, Integer userId, Inventory inventory, Principal user)
			throws InventoryException, UsersException {
		Inventory oldInventory = getInventoryById(inventoryId, userId, user);
		BeanUtils.copyProperties(inventory, oldInventory, utilityHelper.getNullPropertyNames(inventory));
		return inventoryRepo.save(oldInventory);
	}

	@Override
	public Inventory deleteInventoryItem(Integer inventoryItemId, Integer userId, Principal user)
			throws UsersException, InventoryException {
		Inventory inventory = getInventoryById(inventoryItemId, userId, user);
		return inventory;
	}

	@Override
	public List<Inventory> getAllInventoryItems(Integer userId, Principal user)
			throws InventoryException, UsersException {
		return inventoryRepo.findAll();
	}

	@Override
	public Inventory getInventoryById(Integer inventoryItemId, Integer userId, Principal user)
			throws UsersException, InventoryException {
		return inventoryRepo.findById(inventoryItemId).get();
	}

}
