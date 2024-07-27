package practice.coupon_distribution.dao;

import practice.coupon_distribution.exception.CouponDistributionException;
import practice.coupon_distribution.model.Batch;

import java.util.HashMap;
import java.util.Map;

public class CouponDistributionDao {

    HashMap<String, Batch> batchHashMap;

    public CouponDistributionDao(HashMap<String, Batch> batchHashMap) {
        this.batchHashMap = new HashMap<>();
    }

    public Batch getBatch(String batchId) throws CouponDistributionException {
        if(batchHashMap != null && batchHashMap.containsKey(batchId)) {
            return batchHashMap.get(batchId);
        }
        throw new CouponDistributionException("Batch not found");
    }

    public Map<String, Batch> getBatchHashMap() {
        return batchHashMap;
    }

    public void addBatch(Batch batch) {
        if(batchHashMap != null) {
            batchHashMap.put(batch.getBatchId(),batch);
        }
    }
}
