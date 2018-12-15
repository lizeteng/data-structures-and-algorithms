package lizeteng.data_structures_and_algorithms._05_array;

/**
 * Simple ArrayList.
 *
 * @author lizeteng
 * @date 2018/12/15
 */
public class ArrayList {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Shared empty array instance used for empty instances.
     */
    private static final int[] EMPTY_ELEMENTDATA = {};

    /**
     * The array into which elements of the ArrayList are stored.
     */
    private int[] elementData;

    /**
     * The size of the ArrayList (the number of element it contains).
     */
    private int size;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
        elementData = new int[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new int[initialCapacity];
        } else {
            elementData = EMPTY_ELEMENTDATA;
        }
    }

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
     * @return
     */
    public boolean contains(int element) {
        return indexOf(element) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param element element whose presence in this list is to be tested
     * @return
     */
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == element) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param element element whose presence in this list is to be tested
     * @return
     */
    public int lastIndexOf(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i] == element) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return
     */
    public int get(int index) {
        if (!isElementIndex(index)) {
            return -1;
        }

        return elementData[index];
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public int set(int index, int element) {
        if (!isElementIndex(index)) {
            return -1;
        }

        int oldElement = elementData[index];
        elementData[index] = element;

        return oldElement;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return
     */
    public void add(int element) {
        ensureExplicitCapacity(size + 1);

        elementData[size++] = element;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @return
     */
    public void add(int index, int element) {
        if (!isElementIndex(index)) {
            return;
        }

        ensureExplicitCapacity(size + 1);

        for (int i = size - 1; i >= index; i--){
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    public int remove(int index) {
        if (!isElementIndex(index)) {
            return -1;
        }

        int oldElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = 0;

        return oldElement;
    }

    /**
     * Removes all of the elements from this list. The list will
     * be empty after this call returns.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = 0;
        }
        size = 0;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow();
        }
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        int[] newElementData = new int[newCapacity];

        for (int i = 0; i < oldCapacity; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
}
