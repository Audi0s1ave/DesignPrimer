package lld.keyValueStore.storage;

import lld.keyValueStore.eviction.EvictionType;
import lld.keyValueStore.eviction.TTLEviction;
import lld.keyValueStore.storage.Cache;

import java.time.LocalDateTime;
import java.util.HashMap;

public class TTLCache<Key, Value> extends Cache<Key, Value> {

    private HashMap<Key, Value> hashMap;
    private HashMap<Key, LocalDateTime> expiryTime;

    public HashMap<Key, Value> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Key, Value> hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap<Key, LocalDateTime> getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(HashMap<Key, LocalDateTime> expiryTime) {
        this.expiryTime = expiryTime;
    }

    public TTLCache(){
        super(EvictionType.TTL);
        hashMap = new HashMap<>();
        expiryTime = new HashMap<>();
        evictionPolicy = new TTLEviction<>();
    }
    @Override
    public Value get(Key key) {
        evictionPolicy.evictIfExpired(this, key);
        return hashMap.get(key);
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public void put(Key key, Value value, Integer ttlSeconds) {
        hashMap.put(key, value);
        expiryTime.put(key, LocalDateTime.now().plusSeconds(ttlSeconds));
    }

    @Override
    public void delete(Key key) {
        hashMap.remove(key);
        expiryTime.remove(key);
    }
}
