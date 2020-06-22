package DongTaiGuiHua;

/**
 * 整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 * <p>
 * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
 */
public class FindChildArrayMaxValue2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -2, 4};
//        int[] arr = new int[]{-2, 0, -1};
        System.out.println("" + getMax(arr));
        System.out.println("" + getMax2(arr));
    }

    //由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
    public static int getMax(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0;
        int curMax = 1;
        int curMin = 1;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(curMax * nums[i], nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);
            max = Math.max(curMax, max);
        }
        return max;
    }

    public static int getMax2(int[] arr) {
        if (arr == null) return 0;
        int max = Integer.MIN_VALUE;
        int pre = 0;//pre用于计算以arr[i]为结尾元素的连续数组的最大积

        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(pre * arr[i], arr[i]);
//            System.out.println("" + pre);
            max = Math.max(max, pre);
//            System.out.println("" + max);
        }
        return max;
    }
}
