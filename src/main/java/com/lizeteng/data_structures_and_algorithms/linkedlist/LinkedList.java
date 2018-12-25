package lizeteng.data_structures_and_algorithms.linkedlist;

/**
 * Simple linked list
 *
 * @author lizeteng
 * @date 2018/12/25
 */
public class LinkedList {

    /**
     * Pointer to first node.
     */
    private Node first;

    /**
     * Pointer to last node.
     */
    private Node last;

    /**
     * The size of the LinkedList (the number of element it contains).
     */
    private int size;

    /**
     * Constructs an empty list.
     */
    public LinkedList() {}

    /**
     * Returns the number of elements in this list.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param element element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if
     * this list does not contain the element.
     *
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if
     *         this list does not contain the element
     */
    public int indexOf(int element) {
        int index = 0;
        Node node = first;

        while (node != null) {
            if (node.val == element) {
                return index;
            }

            node = node.next;
            index++;
        }

        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if
     * this list does not contain the element.
     *
     * @param element element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if
     *         this list does not contain the element
     */
    public int lastIndexOf(int element) {
        int index = size;
        Node node = last;

        while (node != null) {
            if (node.val == element) {
                return index;
            }

            node = node.prev;
            index--;
        }

        return -1;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        if (!isElementIndex(index)) {
            return -1;
        }

        return node(index).val;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public int set(int index, int element) {
        if (!isElementIndex(index)) {
            return -1;
        }

        Node node = node(index);
        int oldVal = node.val;
        node.val = element;
        
        return oldVal;
    }

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param element element to be appended to this list
     */
    public void add(int element) {
        linkLast(element);
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * 
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    public void add(int index, int element) {
        if (!isPositionIndex(index)) {
            return;
        }
        
        if (index == size) {
            linkLast(element);
        } else{
            linkBefore(node(index), element);
        }
    }

    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     * 
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    public int remove(int index) {
        if (!isElementIndex(index)) {
            return -1;
        }
        
        Node node = node(index);
        
        if (node.prev == null) {
            first = node.next;
        } else {
            node.prev.next = node.next;
        }
        
        if (node.next == null) {
            last = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        size--;
        
        return node.val;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        first = last = null;
        size = 0;
    }

    private Node node(int index) {
        if (index > (size >> 1)) {
            Node node = last;

            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }

            return node;
        } else {
            Node node = first;

            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node;
        }
    }

    private void linkLast(int element) {
        Node oldLast = last;
        Node newLast = new Node(oldLast, element, null);
        last = newLast;

        if (oldLast == null) {
            first = newLast;
        } else {
            oldLast.next = newLast;
        }

        size++;
    }
    
    private void linkBefore(Node node, int element) {
        Node prev = node.prev;
        Node newNode = new Node(prev, element, node);
        node.prev = newNode;
        
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        
        size++;
    }

    private boolean isPositionIndex(int index) {
        return index >=0 && index <= size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private static class Node {

        private int val;

        private Node next;

        private Node prev;

        private Node(Node prev, int element, Node next) {
            this.val = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
