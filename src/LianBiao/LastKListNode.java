package LianBiao;

import mode.ListNode;

/**
 * 链表的倒数第K个节点
 */

public class LastKListNode {
    public static void main(String[] args) {

    }

    private static ListNode findLastK(ListNode head, int k) {
        ListNode pin = head;
        while (k > 0 && head != null) {
            head = head.next;
            k--;
        }//先移动k个节点

        while (head != null) {
            head = head.next;
            pin = pin.next;
        }
        return pin;
    }
}
