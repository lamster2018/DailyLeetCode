package ZhanDuiLie;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定两个序列，第一个表示栈的压栈序列，判断第二个序列是不是该栈的pop顺序
 * 因为压栈中可以 出栈。
 * 假设数字元素都不相同
 */
public class StackPopOrder {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] pop1 = new int[]{4, 5, 3, 2, 1};
        int[] pop2 = new int[]{4, 3, 5, 2, 1};
        int[] pop3 = new int[]{4, 3, 5, 1, 2};
        System.out.println(isPopOrder(arr, pop1));
        System.out.println(isPopOrder(arr, pop2));
        System.out.println(isPopOrder(arr, pop3));
    }

    private static boolean isPopOrder(int[] pushSeq, int[] popSeq) {
        int n = pushSeq.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int pushIdx = 0, popIdx = 0; pushIdx < n; pushIdx++) {
            stack.push(pushSeq[pushIdx]);//先压栈
            while (popIdx < n
                    && !stack.isEmpty()
                    && stack.peek() == popSeq[popIdx]) {
                //每压入一个元素，都从出栈顺序里找元素，
                // 如果出栈顺序是错的，那么一定会卡住pop的操作，最终导致栈不为空
                // 如果是对的，那么popIdx的指针一定能顺利的往下走，而且能把之前的元素pop出去
                stack.pop();
                popIdx++;
            }
        }
        return stack.isEmpty();
    }
}
