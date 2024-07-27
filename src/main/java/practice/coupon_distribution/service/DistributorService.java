package practice.coupon_distribution.service;

import practice.coupon_distribution.dao.CouponDistributionDao;
import practice.coupon_distribution.model.Coupon;

public class DistributorService {

    private CouponDistributionDao couponDistributionDao;

    public DistributorService(CouponDistributionDao couponDistributionDao) {
        this.couponDistributionDao = couponDistributionDao;
    }

    public Coupon grantCoupon(String batchId) {
        return null;
    }

}
