

public class ListNode<E> {
    public ListNode<E> next;
    public ListNode<E> prev;
    private E item;

    public ListNode(E item) {
        this.item = item;
        this.next = null;
    }
    public E getItem() {
        return this.item;
    }
}
