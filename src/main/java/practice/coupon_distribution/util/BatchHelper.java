package practice.coupon_distribution.util;

import practice.coupon_distribution.exception.CouponDistributionException;
import practice.coupon_distribution.model.Batch;

import java.util.Objects;

public class BatchHelper {

    public static boolean isValidBatch(Batch batch) throws CouponDistributionException {
        if(Objects.isNull(batch)
            || batch.getBatchId() == null)
            throw new CouponDistributionException("INVALID_BATCH");
        return true;
    }
}
