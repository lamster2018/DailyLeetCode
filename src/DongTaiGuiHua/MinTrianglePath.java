package DongTaiGuiHua;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 这是个 DP 的问题，有两个点要注意：
 * <p>
 * 从上到下计算的话，最终会生成 n 个值，再取最小值，不如从下到上计算，结果只有一个；
 * 不需要用二维数组记录，因为每一次只会用到前一行的值，使用一位数组就够了。
 * DP 保存中间状态时，考虑两个问题，
 * 一个是中间状态足够计算下一步，
 * 一个是中间状态能得出最终结果，
 * 只要满足这两个条件，中间状态的数据结构越简单越好。
 * 有时候二维的问题可以用一维存储中间状态，一维的问题用一两个变量保存中间状态。这种做法叫做状态压缩。
 */
public class MinTrianglePath {
    public static void main(String[] args) {
//         [[2],[3,4],[6,5,7],[4,1,8,3]];
    }

    // 自低向上
    // 因为，这个三角形的路径所谓的相邻，第i行的第j个，一定会到第 i+1行的 第j个或者第j+1个
    public static int getMin(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        int[] dp = new int[triangle.size() + 1];//相当于是最后一行的下一行,用来记录求第i行是，第i+1行的最小路径和
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }
}
