public class LinkedQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }
    }
    private  Node head;
    private Node tail;
    private int size;
    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        Node ret = head;
        head = head.next;
        ret.next = null;
        if (head == null) {
            tail = null;
        }
        size --;
        return ret.e;
    }
    @Override
    public E getFront() {
        return head.e;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arr = new ArrayQueue<>();
        for (int i = 0; i < 10; i ++) {
            arr.enqueue(i);
            System.out.println(arr);
            if (i % 3 == 2) {
                arr.dequeue();
            }
        }
    }
}
