package ZhanDuiLie;

import java.util.*;


/**
 * 大根堆(前 K 小) / 小根堆（前 K 大)
 */
public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 2, 3, 45, 6, 2, 4, 5, 6, 7, 9, 8, 8};
        for (int i : getTopK(arr, 2)) {
            System.out.println("" + i);
        }
        for (int i : getLeastK(arr, 2)) {
            System.out.println("" + i);
        }
        for (int i : getLeastKTree(arr, 2)) {
            System.out.println("" + i);
        }
    }

    public static int[] getTopK(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            if (pq.size() < k) {//先往里塞k个数
                pq.offer(num);
            } else if (num > pq.peek()) {//如果比小根堆的顶还大，就把顶弹出，因为小根堆的顶是最小的，把数塞进去，顶又是新的最大的数，这样存下来的都是最大的数
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    public static int[] getLeastK(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;//这个只是用来排序的,小的排前面输出，虽然有点说不通，但是大根堆这样写就对了
            }
        });
        for (int num : arr) {//先往里塞k个数
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {//如果比大根堆顶小，大根堆的顶是最大的，就把顶弹出，把数塞进去，顶又是新的最大的数，这样存下来的就是最小的数
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    public static int[] getLeastKTree(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = treeMap.lastEntry();
            if (entry.getKey() > num) {
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    treeMap.pollLastEntry();
                } else {
                    treeMap.put(entry.getKey(), entry.getValue() - 1);
                }
            }

        }

        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }

}
