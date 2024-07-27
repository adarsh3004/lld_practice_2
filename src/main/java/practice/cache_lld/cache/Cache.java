package practice.cache_lld.cache;

import practice.cache_lld.cache.eviction_policy.EvictionStrategy;
import practice.cache_lld.cache.storage.StorageStrategy;

public class Cache<Key,Value> {

    private final EvictionStrategy<Key> evictionStrategy;
    private final StorageStrategy<Key,Value> storageStrategy;

    public Cache(EvictionStrategy<Key> evictionStrategy,StorageStrategy<Key,Value> storageStrategy) {
        this.evictionStrategy = evictionStrategy;
        this.storageStrategy = storageStrategy;
    }

    public void put(Key key, Value value) {
        storageStrategy.add(key,value);
        evictionStrategy.keyAccess(key);
    }

    public Value get(Key key) {
       Value value = storageStrategy.get(key);
        evictionStrategy.keyAccess(key);
        return value;
    }

}
