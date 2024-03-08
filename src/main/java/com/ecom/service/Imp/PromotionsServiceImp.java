package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.PromotionsException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Promotions;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.PromotionsRepo;
import com.ecom.service.PromotionsService;
import com.ecom.service.UsersService;


@Service
public class PromotionsServiceImp implements PromotionsService{
	
	@Autowired
	PromotionsRepo promotionsRepo;
	
	@Autowired
	UtilityHelper utilityHelper;
	
	@Autowired
	UsersService usersService;

	@Override
	public Promotions addPromotion(Promotions promotions, Integer userId, Principal user)
			throws UsersException, PromotionsException {
		return promotionsRepo.save(promotions);
	}

	@Override
	public Promotions updatePromotion(Promotions promotions, Integer promotionId, Integer userId, Principal user)
			throws UsersException, PromotionsException {
		Promotions oldPromotions = getPromotionById(promotionId, userId, user);
		BeanUtils.copyProperties(promotions, oldPromotions, utilityHelper.getNullPropertyNames(promotions));
		return promotionsRepo.save(oldPromotions);
	}

	@Override
	public Promotions getPromotionById(Integer promotionId, Integer userId, Principal user)
			throws UsersException, PromotionsException {
		return promotionsRepo.findById(promotionId).get();
	}

	@Override
	public Promotions deletePromotion(Integer promotionsId, Integer userId, Principal user)
			throws UsersException, PromotionsException {
		Promotions promotions = getPromotionById(promotionsId, userId, user);
		promotionsRepo.deleteById(promotionsId);
		return promotions;
	}

	@Override
	public List<Promotions> getAllPromotions(Integer userId, Principal user)
			throws UsersException, PromotionsException {
		return promotionsRepo.findAll();
	}

}
