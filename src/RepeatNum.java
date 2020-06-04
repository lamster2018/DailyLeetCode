/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 */
public class RepeatNum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5};
        System.out.println("" + getNum(arr));
    }

    private static int getNum(int[] nums) {
        int firstRepeatNum = -1;
        for (int i = 0, len = nums.length; i < len; i++) {
            while (nums[i] != i) {//其实最多就两次循环
                if (nums[i] == nums[nums[i]]) {
                    firstRepeatNum = nums[i];
                    return firstRepeatNum;
                }
                swap(nums, i, nums[i]);
            }
        }
        return firstRepeatNum;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
