public interface Deque<E> {
    int getSize();

    int getCapacity();

    boolean isEmpty();

    void addFront(E e);

    void addTail(E e);

    E removeFront();

    E removeTail();

    E getFront();

    E getLast();
}
