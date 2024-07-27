package practice.coupon_distribution.model;

import practice.coupon_distribution.enums.CouponType;

public class Coupon {

    private String couponCode;
    private CouponType couponType;
    private double worth;

    public Coupon(String couponCode, CouponType couponType, double worth) {
        this.couponCode = couponCode;
        this.couponType = couponType;
        this.worth = worth;
    }


}
