package DongTaiGuiHua;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 */
public class ScrollWindow {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());//前三个先塞进去，求最大。大顶堆就是最大的那个。其余都比顶小。
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);//然后滑动窗口，删除最先进来的
            heap.add(num[j]);//塞入最新进来的
            ret.add(heap.peek());//顶
        }
        return ret;
    }

}
