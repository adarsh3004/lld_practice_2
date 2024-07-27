package practice.coupon_distribution.model;

import practice.coupon_distribution.enums.BatchState;
import practice.coupon_distribution.enums.BatchType;
import practice.coupon_distribution.enums.CouponType;

public class Batch {

    private String batchId;
    private BatchType batchType;
    private BatchState batchState;
    private long validityPeriod; // in days
    private Distributor distributor;
    private CouponType couponType;
    private Double worth;

    public Batch(String batchId, BatchType batchType, long validityPeriod, Distributor distributor, CouponType couponType, Double worth) {
        this.batchId = batchId;
        this.batchType = batchType;
        this.batchState = BatchState.ACTIVE;
        this.validityPeriod = validityPeriod;
        this.distributor = distributor;
        this.couponType = couponType;
        this.worth = worth;
    }

    public String getBatchId() {
        return batchId;
    }

    public BatchType getBatchType() {
        return batchType;
    }

    public BatchState getBatchState() {
        return batchState;
    }

    public long getValidityPeriod() {
        return validityPeriod;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public Double getWorth() {
        return worth;
    }
}
