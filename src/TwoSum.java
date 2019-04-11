import java.util.HashMap;

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