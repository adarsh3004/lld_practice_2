package practice.cache_lld.cache_factory;

import practice.cache_lld.cache.Cache;
import practice.cache_lld.cache.eviction_policy.LRUEvictionPolicy;
import practice.cache_lld.cache.storage.HashBasedStorage;

public class CacheFactory<Key,Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<>(), new HashBasedStorage<>(capacity));
    }
}
