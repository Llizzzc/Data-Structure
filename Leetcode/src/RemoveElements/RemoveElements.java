/*
 * 203. 移除链表元素
 */
package RemoveElements;

class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 4, 5, 7, 6};
        ListNode list = new ListNode(arr);
        System.out.println(list);
        ListNode res = (new RemoveElements()).removeElements(list, 7);
        System.out.println(res);
    }
}
