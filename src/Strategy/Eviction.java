package Strategy;



/**
 * This interface is to support the different types of eviction policies
 * @param <Key>
 */

public interface Eviction<Key> {


    /**
     * Whenever a key is accessed , we should do the appropriate mechanism such that it will not be evicted soon. since we have to preserve
     * the item which are accessing frequently
     * @param key
     */
    void keyAccessed(Key key);

    /**
     * Whenever cache is full, we have to evict the item, this method will do that task
     * @return
     */
    Key evictKey();

}
