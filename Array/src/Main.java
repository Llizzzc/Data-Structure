public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i ++) {
            arr.addList(i);
        }
        System.out.println(arr);
        arr.add(100, 1);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.delete(2);
        System.out.println(arr);
        arr.deleteFirst();
        System.out.println(arr);
        arr.findDelete(9);
        System.out.println(arr);
    }
}
