public class LinkedList<E> {
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
        public  Node() {
            this(null ,null);
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead; // 虚拟头
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void addFirst(E e) {
        add(0, e);
    }
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size ++;
    }
    public void addLast(E e) {
        add(size, e);
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        return cur.e;
    }
    public E getFirst() {
        return get(0);
    }
    public E getList() {
        return get(size - 1);
    }
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0;i < index; i ++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size --;
        return ret.e;
    }
    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size - 1);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedList<Integer>  linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i ++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(3, 5);
        System.out.println(linkedList);
        linkedList.remove(5);
        System.out.println(linkedList);
        linkedList.remove(1);
        System.out.println(linkedList);
    }
}
