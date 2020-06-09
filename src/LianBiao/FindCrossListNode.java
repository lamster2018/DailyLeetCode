package LianBiao;

import mode.ListNode;

/**
 * 无环链表，是否交叉
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */

public class FindCrossListNode {
    public static void main(String[] args) {

    }

    private static ListNode find(ListNode head1, ListNode head2) {
        if (head1 == null | head2 == null) return null;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != p2) {
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1;
    }
}
