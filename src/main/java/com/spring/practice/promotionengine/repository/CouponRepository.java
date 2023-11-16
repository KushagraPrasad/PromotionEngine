package com.spring.practice.promotionengine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.practice.promotionengine.entity.Coupon;

@Repository
@Transactional
public interface CouponRepository extends JpaRepository<Coupon,Long> {

	Optional<Coupon> findByCoupon(String coupon);

	void deleteByCoupon(String coupon);

	List<Coupon> findByLength(Integer length);

}
