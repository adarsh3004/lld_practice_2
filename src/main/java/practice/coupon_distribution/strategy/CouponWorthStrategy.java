package practice.coupon_distribution.strategy;

import practice.coupon_distribution.model.Coupon;

public interface CouponWorthStrategy {

    Double calculateCouponWorth(Coupon coupon);
}
