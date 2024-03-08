package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.InventoryException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Inventory;

public interface InventoryService {
	
	
	Inventory addItemToInventory(Integer userId,Inventory inventory, Principal user) throws InventoryException,UsersException;
	
	Inventory updateInventory(Integer inventoryId,Integer userId,Inventory inventory, Principal user) throws InventoryException,UsersException;
	
	 Inventory deleteInventoryItem(Integer inventoryItemId,Integer userId,Principal user) throws UsersException,InventoryException;
	 
	 List<Inventory> getAllInventoryItems(Integer userId,Principal user) throws InventoryException,UsersException;
	 
	 Inventory getInventoryById(Integer inventoryItemId, Integer userId,Principal user) throws UsersException,InventoryException;
	 
	 
	

}
