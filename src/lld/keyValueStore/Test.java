package lld.keyValueStore;

import lld.keyValueStore.eviction.EvictionType;
import lld.keyValueStore.storage.Cache;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Cache<Integer, String> cache = CacheFactory.getCache(0,"", EvictionType.TTL);
        cache.put(1,"hey", 10);
        cache.put(2, "Hi", 15);
        System.out.println(cache.get(1));
        Thread.sleep(11000);
        System.out.println(cache.get(1));

    }
}
