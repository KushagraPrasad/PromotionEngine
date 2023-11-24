package com.spring.practice.promotionengine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.promotionengine.entity.Coupon;
import com.spring.practice.promotionengine.exception.PromotionServiceException;
import com.spring.practice.promotionengine.repository.CouponRepository;

@Service
public class PromotionEngineImpl implements PromotionEngine {

	private static final Logger logger = Logger.getLogger(PromotionEngineImpl.class.getName());

	@Autowired
	CouponRepository couponRepository;

	public List<Coupon> create(Integer length, Integer count) throws Exception {
		List<String> coupons = new ArrayList<String>();
		List<Coupon> couponList = new ArrayList<Coupon>();
		List<Coupon> savedCoupons = couponRepository.findByLength(length);
		for (int i = 0; i < savedCoupons.size(); i++) {
			coupons.add(savedCoupons.get(i).getCoupon());
		}
		for (int i = 0; i < count; i++) {
			String coupon = RandomStringUtils.randomAlphabetic(length, length);
			if (coupons.contains(coupon)) {
				i--;
			} else {
				coupons.add(coupon);
				Coupon repositoryCoupon = new Coupon(coupon, true, length);
				couponList.add(couponRepository.save(repositoryCoupon));
			}
		}
		logger.info("Coupon Created");
		return couponList;
	}

	public Coupon invalidate(String coupon) throws Exception {
		Optional<Coupon> c1 = couponRepository.findByCoupon(coupon);
		if (c1.isPresent()) {
			c1.get().setValid(false);
			logger.info("Coupon Invalidated");
			return couponRepository.save(c1.get());
		} else {
			throw new PromotionServiceException("coupon is invalid");
		}
	}

	public void delete(String coupon) throws Exception {
		couponRepository.deleteByCoupon(coupon);
		logger.info("Coupon deleted:" + coupon);
	}
	
	
}
