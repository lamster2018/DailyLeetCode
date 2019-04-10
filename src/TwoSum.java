import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        // write your code here
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target)[0] + "--" + twoSum(nums, target)[1]);
    }

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