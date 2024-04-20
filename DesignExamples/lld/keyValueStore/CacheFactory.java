package lld.keyValueStore;

import lld.keyValueStore.eviction.EvictionPolicy;
import lld.keyValueStore.eviction.EvictionType;
import lld.keyValueStore.storage.Cache;
import lld.keyValueStore.storage.LRUCache;
import lld.keyValueStore.storage.TTLCache;


public class CacheFactory{
    public static <Key, Value> Cache<Key, Value> getCache(Key key, Value value, EvictionType evictionType){
        switch (evictionType){
            case LFU:
                return new LRUCache<>();
            case TTL:
                return new TTLCache<>();
        }
        return new LRUCache<>();

    }
}
