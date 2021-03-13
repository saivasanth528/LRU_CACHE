package models;


import exceptions.ElementNotFoundException;

public class DoubleLinkedList<E> {
    DoubleLinkedListNode<E> dummyHead;
    DoubleLinkedListNode<E> dummyTail;

    public DoubleLinkedList() {
        // initializing the double linked list , both the head and tail will point to each other
        dummyHead = new DoubleLinkedListNode<>(null);
        dummyTail = new DoubleLinkedListNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    /**
     * Helper function which will remove the appropriate node from the double linked list
     * @param node
     */

    public void removeNode(DoubleLinkedListNode<E> node) {
        // attaching the links by removing the current element
        if(node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }


    /**
     *  this method will add the given node at last
     * @param node
     */

    public void addNodeAtLast(DoubleLinkedListNode<E> node) {
        DoubleLinkedListNode tailPreviousNode = dummyTail.prev;
        tailPreviousNode.next = node;
        node.next = dummyTail;
        dummyTail.prev = node;
        node.prev = tailPreviousNode;

    }

    /**
     * This function will create the node from the given element and add it to the end of the linked list
     * @param element
     * @return address of created node
     */

    public DoubleLinkedListNode<E> addElementToTheEndOfList(E element) {
        if(element == null) {
            throw new ElementNotFoundException("Give the valid element");
        }

        DoubleLinkedListNode<E> newNode = new DoubleLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;

    }

    public boolean isListEmpty() {
        return dummyHead.next == dummyTail;
    }


    public DoubleLinkedListNode getFirstNode() {
        if(isListEmpty()) {
            return null;
        }
        return  dummyHead.next;
    }

    public DoubleLinkedListNode getLastNode() {
        if(isListEmpty()) {
            return null;
        }
        return  dummyTail.prev;
    }





}
