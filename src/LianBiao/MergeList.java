package LianBiao;

import mode.ListNode;

/**
 * 合并两个有序链表
 */

public class MergeList {
    public static void main(String[] args) {

    }

    //迭代法
    private static ListNode merge(ListNode p1, ListNode p2) {
        ListNode head = new ListNode();//造一个假的头结点
        ListNode cur = head;//cur是真正的操作节点
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {//因为是有序链表，相当于把每个node重新指到cur这条新链上
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
        }
        if (p1 != null) cur.next = p1;
        if (p2 != null) cur.next = p2;
        return head.next;
    }

    //递归法
    private static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

}
