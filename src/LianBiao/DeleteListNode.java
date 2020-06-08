package LianBiao;

import mode.ListNode;

/**
 * 在 O(1) 时间内删除链表节点
 * 如果删除的节点是非尾节点，复杂度是O（1），需要操作  n-1个节点
 * 如果删除的节点是尾节点，复杂度是 O（n），需要操作 1个节点
 * <p>
 * 平均复杂度是  （n-1 + n） / n = O(1)
 * 我不太明白这个平均可以这样平均
 */
public class DeleteListNode {
    public static void main(String[] args) {

    }

    private static ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点,复杂度就是1，处理方法就是 找到要删除的节点的下一个节点，把下一个节点的值跟指向赋给本身，相当于狸猫换太子
            ListNode next = tobeDelete.next;
            tobeDelete.value = next.value;
            tobeDelete.next = next.next;
            next.next = null;//断链，可省，无非就是多了一个支路
        } else {
            if (head == tobeDelete)
                // 只有一个节点
                head = null;
            else {//这是尾节点，就必须遍历到上一个节点，因为无法使用狸猫换太子的方案
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }

}
