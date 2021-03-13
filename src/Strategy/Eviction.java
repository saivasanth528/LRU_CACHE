package Strategy;



/**
 * This interface is to support the different types of eviction policies
 * @param <Key>
 */

public interface Eviction<Key> {


    void keyAccessed(Key key);

    Key evictKey();

}
