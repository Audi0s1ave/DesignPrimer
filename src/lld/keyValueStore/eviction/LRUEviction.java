package lld.keyValueStore.eviction;

import lld.keyValueStore.storage.Cache;
import lld.keyValueStore.storage.LRUCache;

public class LRUEviction<Key, Value> implements EvictionPolicy<Key, Value> {

    @Override
    public void evict(Cache<Key, Value> cache) {
        LRUCache<Key, Value> lruCache = (LRUCache<Key, Value>) cache;
        lruCache.getHashMap().remove(lruCache.getLinkedList().getFirst());
        lruCache.getLinkedList().removeFirst();
    }

    @Override
    public void evictIfExpired(Cache<Key, Value> cache, Key k) {

    }
}
