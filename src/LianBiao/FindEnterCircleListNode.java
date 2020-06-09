package LianBiao;

import mode.ListNode;

/**
 * 找入环点
 */
public class FindEnterCircleListNode {
    public static void main(String[] args) {

    }

    private static ListNode find(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
