package cache;

import Strategy.Eviction;
import exceptions.ElementNotFoundException;
import exceptions.MemoryExceededException;
import models.Storage;

public class Cache<Key, Value> {
    private final Eviction<Key> evictionStrategy;
    private final Storage<Key, Value> storage;

    public Cache(Eviction<Key> eviction, Storage<Key, Value> storage) {
        this.evictionStrategy = eviction;
        this.storage = storage;
    }

    /**
     * Add the key value pair to the cache, if the cache is full, evicts the element automatically based on eviction strategy and
     * adds the new element to the cache;
     * @param key
     * @param value
     */

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionStrategy.keyAccessed(key);
        } catch (MemoryExceededException exception) {
            System.out.print("Cache capacity full, evicting one item \n");
            Key removedKey = evictionStrategy.evictKey();
            if(removedKey == null) {
                throw new  RuntimeException("Failed to evict the element, unexpected error occured\n");
            }
            this.storage.remove(removedKey);
            System.out.print("Evicted least recently used item " + removedKey + "\n");
            put(key, value);

        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionStrategy.keyAccessed(key);
            return value;
        } catch (ElementNotFoundException exception) {
            System.out.print("The element which you tried to access is not there in the cache\n");
            return null;
        }
    }
}
