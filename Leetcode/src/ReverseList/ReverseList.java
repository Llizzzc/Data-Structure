/*
 * 206. 反转链表
 */
package ReverseList;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode list = new ListNode(arr);
        System.out.println(list);
        ListNode res = (new ReverseList()).reverseList(list);
        System.out.println(res);
    }
}
