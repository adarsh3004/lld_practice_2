package practice.cache_lld.cache.storage;

import practice.cache_lld.exception.NotFoundException;
import practice.cache_lld.exception.StorageFullException;

import java.util.HashMap;

public class HashBasedStorage<Key, Value> implements StorageStrategy<Key,Value> {

    int capacity;
    HashMap<Key,Value> cache;

    public HashBasedStorage(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) {
        if(cache.size() >= capacity)
            throw new StorageFullException("Not Enough Space");
        cache.put(key,value);
    }

    @Override
    public void remove(Key key) {
        if(!cache.containsKey(key))
            throw new NotFoundException("Key not found");
        cache.remove(key);
    }

    @Override
    public Value get(Key key) {
        if(!cache.containsKey(key))
            throw new NotFoundException("Key not found");
        return cache.get(key);
    }
}
