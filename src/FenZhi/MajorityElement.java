package FenZhi;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(getValue(arr));
        System.out.println(getValueSort(arr));
    }

    //从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
    // 摩尔投票法，On
    private static int getValue(int[] nums) {
        int value = 1;
        int num = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            if (num != nums[i]) {
                value--;
                if (value == 0) {
                    num = nums[i];
                    value = 1;
                }
            } else {
                value++;
            }
        }
        return num;
    }

    //时间复杂度 O(NlogN)
    private static int getValueSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2 + 1];
    }
}
