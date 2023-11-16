package com.spring.practice.promotionengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.practice.promotionengine.entity.Coupon;
import com.spring.practice.promotionengine.service.PromotionEngine;

@RestController
@RequestMapping("/api")
public class PromotionEngineController {

	@Autowired
	PromotionEngine promotionEngine;

	@RequestMapping(value = "/coupon", method = RequestMethod.GET)
	public List<Coupon> createCoupon(@RequestParam Integer length, @RequestParam Integer count) throws Exception {
		List<Coupon> coupons = promotionEngine.create(length, count);
		return coupons;
	}

	@PutMapping("/coupon/{coupon}")
	public Coupon invalidate(@PathVariable String coupon) throws Exception {
		return promotionEngine.invalidate(coupon);
	}

	@RequestMapping(value = "/coupon/{coupon}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String coupon) throws Exception {
		promotionEngine.delete(coupon);
	}
}
