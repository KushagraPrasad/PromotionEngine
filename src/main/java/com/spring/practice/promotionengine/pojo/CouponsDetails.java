package com.spring.practice.promotionengine.pojo;

public class CouponsDetails {

	private String Coupon;
	private long id;

	public String getCoupon() {
		return Coupon;
	}

	public void setCoupon(String coupon) {
		Coupon = coupon;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CouponsDetails [Coupon=" + Coupon + ", id=" + id + "]";
	}
}
