package practice.cache_lld.cache.storage;

public interface StorageStrategy<Key, Value> {

    void add(Key key,Value value);
    void remove(Key key);
    Value get(Key key);
}
