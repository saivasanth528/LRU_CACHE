package models;


import lombok.Getter;

/**
 * Apart from storage we have to keep track of elements to evict a particular key,
 * This double linked list  is a wrapper on top of it .
 * @param <E>
 */

@Getter
public class DoubleLinkedListNode<E> {
    DoubleLinkedListNode<E> next;
    DoubleLinkedListNode<E> prev;
    E element;

    public DoubleLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
