package factories;

import Strategy.LRUEvictionStrategy;
import cache.Cache;
import models.InMemoryHashMapStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCacheMechanism(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionStrategy<Key>(), new InMemoryHashMapStorage<Key, Value>(capacity));
    }
}
