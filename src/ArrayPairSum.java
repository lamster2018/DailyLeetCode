import java.util.Arrays;

/**
 * 给定长度为 2n 的数组,
 * 你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * https://leetcode-cn.com/problems/array-partition-i/
 */
public class ArrayPairSum {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        System.out.println(arrayPairSum(a));
    }

    /**
     * 田忌赛马的策略，两两配对找最小的那个，然后求最大的和。
     * 那策略就是尽可能的大的和次大的放一组。
     * 排序之后，实际上就是找第奇数个数，然后求和
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len; ) {
            result += nums[i];
            i += 2;
        }
        return result;
    }
}
