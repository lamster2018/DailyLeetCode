import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        // write your code here
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target)[0] + "--" + twoSum(nums, target)[1]);
    }

    /**
     * 给任一数组和目标值
     * 求数组内两数和为目标值的 两数下标
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    static int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap<Integer, Integer>();

        for (int i = 0, len = nums.length; i < len; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{(int) map.get(temp), i};
            } else
                map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}