import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现，不要用queue，直接用linkedList替代
 * linkedList的offer方法，就是add，直接加到尾节点
 * poll方法，就是unlinkFirst，删除头节点
 * 所以是个完美的  先进，先出的结构
 */
public class StackUseQueue {
    private final Queue<Integer> q;

    public StackUseQueue() {
        q = new LinkedList<>();
    }

    // offer的节点是后进的，但是为了要做到先出，就用poll方法拿到头节点
    // 把头结点一个一个再offer到尾部，最后一个就是刚才新加入的节点
    // 下次要pop的节点就是这个后进的节点
    public void push(int x) {
        q.offer(x);
        for (int i = 0, len = q.size() - 1; i < len; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
