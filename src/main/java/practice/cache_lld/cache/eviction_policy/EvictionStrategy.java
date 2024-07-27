package practice.cache_lld.cache.eviction_policy;

public interface EvictionStrategy<Key> {

    void keyAccess(Key kay);
    Key evict(Key key);
}
