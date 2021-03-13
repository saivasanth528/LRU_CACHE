package Strategy;


import models.DoubleLinkedList;
import models.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  This Eviction strategy is based on LRU mechanism
 */


public class LRUEvictionStrategy<Key> implements Eviction<Key> {

    private DoubleLinkedList<Key> dll;
    // this is to get the reference of specific element in O(1) time instead of O(n)
    private Map<Key, DoubleLinkedListNode<Key>> referencer;

    public LRUEvictionStrategy() {
        this.dll = new DoubleLinkedList<>();
        this.referencer = new HashMap<>();
    }


    @Override
    public void keyAccessed(Key key) {
        if(referencer.containsKey(key)) {
            // we are moving the current accessed element to the end of the list to move this element away from eviction
            dll.removeNode(referencer.get(key));
            dll.addNodeAtLast(referencer.get(key));
        } else {
            DoubleLinkedListNode<Key> newNode = dll.addElementToTheEndOfList(key);
            referencer.put(key, newNode);
        }
    }

    /**
     * Here the eviction strategy is we are removing the first element of the linked list, whenever cache capacity is full
     * Why the first element, because we are strategize in such a way that the first element is the least accessed element
     * @return the removed element
     */
    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> first  = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.removeNode(first);
        return first.getElement();
    }
}
