import mode.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    //头插法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;//先保留 当前节点的原下一个节点
            curr.next = prev;//断链，当前节点的下一个节点，反转
            prev = curr;//这个节点已经操作完毕，prev就是这个已经操作完毕的节点
            curr = next;//把待反转的节点指向下一个要操作的节点
        }
        return prev;//最终全部操作完毕
    }

    //迭代法
    public ListNode reverseList2(ListNode head) {
        //1.中断条件
        if (head == null || head.next == null) {
            return head;
        }
        //3.本层要干什么
        ListNode next = head.next;
        head.next = reverseList2(next.next);
        head.next.next = head;
        //2.要返回给下一层什么
        return next;
    }
}
