package LianBiao;

/**
 * 复杂链表的复制
 * (每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的 head。
 * <p>
 * 跟普通复制不同的是，不能简单的递归下去，因为下一级的任意节点是random
 */
public class RandomListNode {
    public static void main(String[] args) {

    }

//    public RandomListNode Clone(RandomListNode pHead) {
//        if (pHead == null) return null;

//        // 插入新节点
//        RandomListNode cur = pHead;
//        while (cur != null) {
//            RandomListNode clone = new RandomListNode(cur.label);
//            clone.next = cur.next;
//            cur.next = clone;
//            cur = clone.next;
//        }

//        // 建立 random 链接
//        cur = pHead;
//        while (cur != null) {
//            RandomListNode clone = cur.next;
//            if (cur.random != null)
//                clone.random = cur.random.next;
//            cur = clone.next;
//        }

//        // 拆分
//        cur = pHead;
//        RandomListNode pCloneHead = pHead.next;
//        while (cur.next != null) {
//            RandomListNode next = cur.next;
//            cur.next = next.next;
//            cur = next;
//        }
//        return pCloneHead;
//    }
}