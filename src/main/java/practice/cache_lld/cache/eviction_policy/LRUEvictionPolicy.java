package practice.cache_lld.cache.eviction_policy;

public class LRUEvictionPolicy<Key> implements EvictionStrategy<Key> {


    @Override
    public void keyAccess(Key kay) {

    }

    @Override
    public Key evict(Key key) {
        return null;
    }
}
