public class  LinkedStack<E> implements Stack<E> {

    private LinkedList<E> list;
    public LinkedStack() {
        list = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public E peek() {
        return list.getFirst();
    }
    @Override
    public E pop() {
        return list.removeFirst();
    }
    @Override
    public void push(E e) {
        list.addFirst(e);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> arr = new LinkedStack<>();
        for (int i = 0; i < 10; i ++) {
            arr.push(i);
            System.out.println(arr);
        }

    }
}
