package practice.coupon_distribution.service;

import practice.coupon_distribution.dao.CouponDistributionDao;

import java.util.Set;

public class CouponService {

    private CouponDistributionDao couponDistributionDao;

    public CouponService(CouponDistributionDao couponDistributionDao) {
        this.couponDistributionDao = couponDistributionDao;
    }

    public void ingestCoupons(String batchId, Set<String> couponCodes) {

    }


}
