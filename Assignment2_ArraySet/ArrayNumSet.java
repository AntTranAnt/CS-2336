/*
 * Anthony Tran
 * CS 2336.003
 * 4/12/2023
 * ArrayNumSet class mimics java ArraySet
 * ArrayNumSet supports generic types of Number
 * Program throws NullPointerExceptions when type E is not a Number
 * Public methods implemented are add, contains, capacity, size, getIndex, remove
 */

public class ArrayNumSet<E extends Number> implements NumSet<E> {
    private Object[] myArray; 
    int size; //number of elements
    int capacity; //capacity of underlying array

    ArrayNumSet(int initialCapacity) {
        this.capacity = initialCapacity;
        myArray = new Object[capacity];
        this.size = 0;
    }

    // add an element e to the set if it does not already exist in the set
    // return true if this set did not already contain the specified element
    // throws NullPointerException if element e is null
    @Override
    public boolean add(E e) {
        if (e == null) { //check for null
            throw new NullPointerException();
        } else if (contains(e)) { //check if e already in array
            return false;
        } else {
            if (this.size == this.capacity) { // check if array full
                increaseArray();
            }
            myArray[this.size] = e;
            this.size++;
            return true;
        }
    }
    
    // return the size of the underlying array
    @Override
    public int capacity() {
        return capacity;
    }
    
    // return true if given element e is in the set
    // throws NullPointerException if element e is null
    @Override
    public boolean contains(E e) {
        if (e == null) { //check if e is null
            throw new NullPointerException();
        }
        //linear search to find e
        for (int i = 0; i < this.size; i++) { 
            if (myArray[i] == e) {
                return true;
            }
        }
        return false;
    }
    
    // returns the element at the specified index in this list
    // throws IndexOutOfBoundsException is index is negative or >= size()
    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new NullPointerException();
        }
            //typecasts object to type E and return
            @SuppressWarnings("unchecked")
            E result = (E) myArray[index];
            return result;
        
    }

    //returns index of object e
    //returns -1 if e not in array
    //throws IndexOutOfBoundsException if e null
    public int getIndex(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.size; i++) {
            if (myArray[i] == e) {
                return i;
            }
        }
        return -1;
    }
    
    // remove an element e from the set if it exists in the set
    // return true if an element was removed (set changed)
    // throws NullPointerException if element e is null
    @Override
    public boolean remove(E e) {
        if (e == null) { //check for null
            throw new NullPointerException();
        }
        int index = getIndex(e);
        if (index == -1) { //check if e already in array
            return false;
        } else {
            myArray[index] = null;
            //move all elements after index back by 1
            for (int i = index; i < this.size - 1; i++) { 
                myArray[i] = myArray[i + 1];
            }
            this.size -= 1;
            return true;
        }
    }
    
    // return the set size (number of elements in set)
    @Override
    public int size() {
        return size;
    }

    //doubles sizeof array
    //private method so only class can use.
    private void increaseArray() {
        this.capacity *= 2;
        Object[] newArray = new Object[this.capacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = myArray[i];
        }
        myArray = newArray;
    }
}