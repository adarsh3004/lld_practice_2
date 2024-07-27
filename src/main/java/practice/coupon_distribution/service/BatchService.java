package practice.coupon_distribution.service;

import practice.coupon_distribution.dao.CouponDistributionDao;
import practice.coupon_distribution.enums.BatchState;
import practice.coupon_distribution.exception.CouponDistributionException;
import practice.coupon_distribution.model.Batch;
import practice.coupon_distribution.util.BatchHelper;

import java.util.Objects;

public class BatchService {

    private CouponDistributionDao couponDistributionDao;

    public BatchService(CouponDistributionDao couponDistributionDao) {
        this.couponDistributionDao = couponDistributionDao;
    }

    public void createBatch(Batch batch) throws CouponDistributionException {
        if(BatchHelper.isValidBatch(batch))
            couponDistributionDao.addBatch(batch);
    }

    public void updateState(String batchId, BatchState batchState) {

    }

    public Batch getBatch(String batchId) throws CouponDistributionException {
        return couponDistributionDao.getBatch(batchId);
    }

    public boolean isBatchAvailable(String batchId) throws CouponDistributionException {
        Batch batch = couponDistributionDao.getBatch(batchId);
        if(Objects.nonNull(batch)) {
            return batch.getBatchState().equals(BatchState.ACTIVE);
        }
        return false;
    }
}
