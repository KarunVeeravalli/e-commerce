package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.PromotionsException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Promotions;

public interface PromotionsService {
	
	Promotions addPromotion(Promotions promotions,Integer userId,Principal user) throws UsersException,PromotionsException;
	
	Promotions updatePromotion(Promotions promotions,Integer promotionId,Integer userId,Principal user) throws UsersException,PromotionsException;
	
	Promotions getPromotionById(Integer promotionId,Integer userId,Principal user) throws UsersException,PromotionsException;
	
	Promotions deletePromotion(Integer promotionsId,Integer userId,Principal user) throws UsersException,PromotionsException;
	
	List<Promotions> getAllPromotions(Integer userId,Principal user) throws UsersException,PromotionsException;
	
	

}
