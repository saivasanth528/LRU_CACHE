package models;


import exceptions.ElementNotFoundException;
import exceptions.MemoryExceededException;

/*

    In future if we want to come up with the different type of storage for different class of requirements,
    we can use this interface in a generic way. Supporting the Open Close Principle
 */

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws MemoryExceededException;

    void remove(Key key) throws ElementNotFoundException;

    Value get(Key key) throws ElementNotFoundException;
}
