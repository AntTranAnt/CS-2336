

public class SLinkedList <E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int length;
    
    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    public int size() {
        return this.length;
    }
    
    public E removeFirst() {
        if (this.head == null) {
            throw new NullPointerException();
        }
        
        E retVal = this.head.getItem();
        
        if (this.head == this.tail) {
            this.tail = null;
        }
        
        this.head = this.head.next;
        
        this.length--;
        
        return retVal;
    }
    
    public void prepend(E item) {
        ListNode<E> newNode = new ListNode<>(item);
        
        if (this.head == null) {
            this.tail = newNode;
        }
        else {
            newNode.next = this.head;
        }
        
        this.head = newNode;
        this.length++;
    }
    
    public void append(E item) {
        ListNode<E> newNode = new ListNode<>(item);
        
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            this.tail.next = newNode;
        }
        
        this.tail = newNode;
        this.length++;
    }
    
    @Override
    public String toString() {
        ListNode<E> curNode = this.head;
        String someStr = "";
        
        for(int i = 0; i < this.length; i++) {
            someStr += curNode.getItem() + " ";
            curNode = curNode.next;
        }
        
        return someStr;
    }

    //stack methods
    public void push(E item) {
        this.prepend(item);
    }

    public E pop() {
        return this.removeFirst();
    }

    public E peek() {
        if (this.head == null) {
            throw new NullPointerException();
        }
        return this.head.getItem();
    }

    //Queue methods:
    public void enqueue(E item) {
        this.append(item);
    }

    public E removeLast() {
        if (this.head == null) {
            throw new NullPointerException();
        }
        E retVal = this.tail.getItem();
        if (this.head == this.tail) {
            this.head = null;
        } else {
            this.tail.prev.next = null;
        }
        this.tail = this.tail.prev;
        this.length--;
        return retVal;
    }
}