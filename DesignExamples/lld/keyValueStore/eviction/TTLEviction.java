package lld.keyValueStore.eviction;

import lld.keyValueStore.storage.Cache;
import lld.keyValueStore.storage.TTLCache;

import java.time.LocalDateTime;

public class TTLEviction<Key, Value> implements EvictionPolicy<Key, Value> {
    @Override
    public void evict(Cache<Key, Value> cache) {

    }
    @Override
    public void evictIfExpired(Cache<Key, Value> cache, Key key) {
        TTLCache<Key, Value> ttlCache = (TTLCache<Key, Value>) cache;
        if(ttlCache.getExpiryTime().get(key).isBefore(LocalDateTime.now())){
            ttlCache.delete(key);
        }
    }
}
