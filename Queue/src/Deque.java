public interface Deque<E> {
    int getSize();
    boolean isEmpty();
    void addFront(E e);
    void addTail(E e);
    E removeFront();
    E removeTail();
    E getFront();
}
