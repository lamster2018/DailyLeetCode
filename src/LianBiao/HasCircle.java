package LianBiao;

import mode.ListNode;

public class HasCircle {
    public static void main(String[] args) {

    }

    private static boolean hasCircle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
