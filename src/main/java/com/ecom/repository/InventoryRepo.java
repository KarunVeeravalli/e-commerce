package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer>  {

}
