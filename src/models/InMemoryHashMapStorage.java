package models;

import exceptions.ElementNotFoundException;
import exceptions.MemoryExceededException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryHashMapStorage<Key, Value> implements Storage<Key, Value> {

    private final Integer capacity;
    Map<Key, Value>  storage;

    public InMemoryHashMapStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }


    @Override
    public void add(Key key, Value value) throws MemoryExceededException {
        if (isStorageFull()) throw new MemoryExceededException("Memory limit exceeded, please evict");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws ElementNotFoundException {
        if (!storage.containsKey(key)) throw new ElementNotFoundException(key + "doesn't exist in the cache.");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws ElementNotFoundException {
        if (!storage.containsKey(key)) throw new ElementNotFoundException(key + "doesn't exist in the cache.");
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}
