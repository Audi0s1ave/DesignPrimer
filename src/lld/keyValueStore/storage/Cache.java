package lld.keyValueStore.storage;

import lld.keyValueStore.eviction.EvictionPolicy;
import lld.keyValueStore.eviction.EvictionType;

public abstract class Cache<Key, Value> {
    private EvictionType evictionType;
    public EvictionPolicy<Key, Value> evictionPolicy;
    public Cache(EvictionType evictionType){
        this.evictionType = evictionType;
    }
    public abstract Value get(Key key);
    public abstract void put(Key key, Value v);
    public abstract void put(Key key, Value v, Integer ttlSeconds);
    public abstract void delete(Key key);

}
