package com.ecom.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.GeneralResponse;
import com.ecom.exceptions.InventoryException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Inventory;
import com.ecom.service.InventoryService;




@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {
	@Autowired
	InventoryService inventoryService;
	
	@PutMapping("updateInventory/{userId}/{inventoryId}")
	ResponseEntity<GeneralResponse> updateInventory(@RequestBody Inventory inventory,@PathVariable Integer userId,@PathVariable Integer inventoryId, Principal user) throws UsersException,InventoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Inventory updated by user Id : " + userId);
		generalResponse.setData(inventoryService.updateInventory( inventoryId, userId,inventory, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addItemToInventory/{userId}")
	ResponseEntity<GeneralResponse> addItemToInventory(@RequestBody Inventory inventory,@PathVariable Integer userId, Principal user) throws UsersException,InventoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Inventory added by user Id : " + userId);
		generalResponse.setData(inventoryService.addItemToInventory(  userId,inventory, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deleteInventoryItem/{userId}/{inventoryId}")
	ResponseEntity<GeneralResponse> deleteInventoryItem(@PathVariable Integer userId,@PathVariable Integer inventoryId, Principal user) throws UsersException,InventoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Inventory deleted by user Id : " + userId);
		generalResponse.setData(inventoryService.deleteInventoryItem(inventoryId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getInventoryById/{userId}/{inventoryId}")
	ResponseEntity<GeneralResponse> getInventoryById(@PathVariable Integer userId, @PathVariable Integer inventoryId,Principal user) throws UsersException,InventoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Inventory found by user Id : " + userId);
		generalResponse.setData(inventoryService.getInventoryById(inventoryId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllInventoryItems/{userId}")
	ResponseEntity<GeneralResponse> getAllInventoryItems(@PathVariable Integer userId, Principal user) throws UsersException,InventoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Inventory items found by user Id : " + userId);
		generalResponse.setData(inventoryService.getAllInventoryItems(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	

}
