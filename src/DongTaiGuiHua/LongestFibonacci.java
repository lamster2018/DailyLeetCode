package DongTaiGuiHua;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * <p>
 * （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 * https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/
 */
public class LongestFibonacci {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.printf("" + getLen(arr));
    }

    /**
     * 将斐波那契式的子序列中的两个连续项 A[i], A[j] 视为单个结点 (i, j)，整个子序列是这些连续结点之间的路径。
     * 例如，对于斐波那契式的子序列 (A[1] = 2, A[2] = 3, A[4] = 5, A[7] = 8, A[10] = 13)，结点之间的路径为 (1, 2) <-> (2, 4) <-> (4, 7) <-> (7, 10)。
     * 这样做的动机是，只有当 A[i] + A[j] == A[k] 时，两结点 (i, j) 和 (j, k) 才是连通的，我们需要这些信息才能知道这一连通。现在我们得到一个类似于 最长上升子序列 的问题。
     * 算法
     * 设 longest[i, j] 是结束在 [i, j] 的最长路径。那么 如果 (i, j) 和 (j, k) 是连通的， longest[j, k] = longest[i, j] + 1。
     * 由于 i 由 A.index(A[k] - A[j]) 唯一确定，所以这是有效的：我们在 i 潜在时检查每组 j < k，并相应地更新 longest[j, k]。
     */
    public static int getLen(int[] nums) {
        if (nums.length < 3) return 0;
        int N = nums.length;
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i) {//这里是 先自加
            index.put(nums[i], i);
        }

        Map<Integer, Integer> longest = new HashMap();
        int ans = 0;

        for (int k = 0; k < N; ++k) {
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(nums[k] - nums[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int cand = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, cand);
                    ans = Math.max(ans, cand);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }
}
