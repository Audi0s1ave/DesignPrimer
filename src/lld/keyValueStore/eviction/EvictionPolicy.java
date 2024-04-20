package lld.keyValueStore.eviction;

import lld.keyValueStore.storage.Cache;

public interface EvictionPolicy<Key, Value> {

    void evict(Cache<Key, Value> cache);

    void evictIfExpired(Cache<Key, Value> cache, Key k);

}
