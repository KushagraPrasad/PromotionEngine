package com.spring.practice.promotionengine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.practice.promotionengine.entity.Coupon;

@Service
public interface PromotionEngine {

	public List<Coupon> create(Integer length, Integer count) throws Exception;

	public Coupon invalidate(String coupon) throws Exception;

	public void delete(String coupon) throws Exception;
}