package ZhanDuiLie;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈实现队列
 * 栈别用stack，用LinkedList来代替,其实现了deque接口(双端队列），queue是队列，但是没有push，pop方法
 * push方法的内部实现，addFirst,加到链表头节点的prev
 * pop方法的内部实现，removeFirst
 * 这样LinkedList实际上是个完美的后进先出
 * 图像化的理解就是，把一个 从左至右的 链表，以尾节点为圆心，顺时针移动90度，这样头节点就是栈顶
 */
public class QueueUseStack {
    private final Deque<Integer> s1;
    private final Deque<Integer> s2;//

    public QueueUseStack() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void push(int x) {
        s2.push(x);
    }

    //出栈
    public int pop() {
        peek();
        return s1.pop();//removeFirst
    }

    //得到栈顶元素, 但是不出栈,只是getFirst
    public int peek() {
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
