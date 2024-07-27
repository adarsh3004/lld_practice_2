package practice.coupon_distribution.model.states;

public interface State {

    void approveBatch();
    void defineBatch();
    void expireBatch();
    void terminateBatch();
}
