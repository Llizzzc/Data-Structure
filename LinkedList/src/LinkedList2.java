
public class LinkedList2<E> {
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
    private Node head;
    private int size;
    public LinkedList2() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        head = add(index, e, head);
        size ++;
    }
    private Node add(int index, E e, Node node) {
        if (index == 0) {
            return new Node(e, node);
        } else {
            node.next = add(index - 1, e, node.next);
            return node;
        }

    }
    public void addFirst(E e) {
        add(0, e);
    }
    public void addLast(E e) {
        add(size, e);
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        return get(index, head);
    }
    private E get(int index, Node node) {
        if (index == 0) {
            return node.e;
        } else {
            return get(index - 1, node.next);
        }
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
        set(index, e, head);
    }
    private void set(int index, E e, Node node) {
        if (index == 0) {
            node.e = e;
        } else {
            set(index - 1, e, node.next);
        }
    }

    public boolean contains(E e) {
        return contains(e, head);
    }
    private boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        } else {
            return contains(e, node.next);
        }
    }
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        size --;
        return remove(index, head);
    }
    private E remove(int index, Node node) {
        if (index == 0) {
            E ret = node.e;
            node = node.next;
            return ret;
        }
        if (index - 1 == 0) {
            E ret = node.next.e;
            node.next = node.next.next;
            return ret;
        }
        return remove(index - 1, node.next);
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
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedList2<Integer>  linkedList = new LinkedList2<>();
        for (int i = 0; i < 5; i ++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList);
    }
}

