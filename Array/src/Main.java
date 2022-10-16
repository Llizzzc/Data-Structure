public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(1);
        arr.addLast(3);
        arr.addLast(2);
        arr.addLast(1);
        arr.addLast(1);

        for (int index : arr.findAll(1)) {
            System.out.println(index);
        }

        System.out.println(arr);
        arr.findDelete(2);
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
        for (int i = 0; i < 9; i++) {
            arr.addLast(9);
            System.out.println(arr);
        }
    }
}
