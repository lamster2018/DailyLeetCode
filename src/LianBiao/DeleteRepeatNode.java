package LianBiao;

import mode.ListNode;

/**
 * 这个我感觉还是可以用狸猫换太子的方式处理
 */
public class DeleteRepeatNode {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {//重复
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
