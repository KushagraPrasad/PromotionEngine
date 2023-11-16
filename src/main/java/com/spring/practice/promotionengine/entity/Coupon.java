package com.spring.practice.promotionengine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupon {
	private String coupon;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	boolean isValid;
	private int length;

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Coupon(String coupon, long id, boolean isValid, int length) {
		super();
		this.coupon = coupon;
		this.id = id;
		this.isValid = isValid;
		this.length = length;
	}

	public Coupon(String coupon, boolean isValid, int length) {
		super();
		this.coupon = coupon;
		this.isValid = isValid;
		this.length = length;
	}

	public Coupon() {
		
	}
	
	@Override
	public String toString() {
		return "Coupon [coupon=" + coupon + ", id=" + id + ", isValid=" + isValid + ", length=" + length + "]";
	}

}
