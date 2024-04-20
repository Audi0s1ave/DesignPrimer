package lld.keyValueStore.storage;

import lld.keyValueStore.eviction.EvictionType;
import lld.keyValueStore.eviction.LRUEviction;
import lld.keyValueStore.storage.Cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<Key, Value> extends Cache<Key, Value> {

    LinkedList<Key> linkedList;
    HashMap<Key, Value> hashMap;

    public LinkedList<Key> getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(LinkedList<Key> linkedList) {
        this.linkedList = linkedList;
    }

    public HashMap<Key, Value> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Key, Value> hashMap) {
        this.hashMap = hashMap;
    }


    public LRUCache(){
        super(EvictionType.LRU);
        linkedList = new LinkedList<>();
        hashMap = new HashMap<>();
        evictionPolicy = new LRUEviction<>();
    }

    @Override
    public Value get(Key key) {
        linkedList.removeFirstOccurrence(key);
        linkedList.addLast(key);
        return hashMap.get(key);
    }

    @Override
    public void put(Key key, Value value) {
        linkedList.removeFirstOccurrence(key);
        hashMap.put(key, value);
        linkedList.addLast(key);
    }

    @Override
    public void put(Key key, Value v, Integer ttlSeconds) {
        System.out.println("Not Implemented");
    }

    @Override
    public void delete(Key key) {
        hashMap.remove(key);
        linkedList.removeFirstOccurrence(key);
    }

    public void evict(){
        evictionPolicy.evict(this);
    }

}
