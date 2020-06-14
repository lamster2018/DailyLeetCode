package PaiXu;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 32, 321};
        System.out.println(printMinNumber(arr));
    }

    /**
     * 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
     *
     * @param numbers
     * @return
     */
    private static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++)
            nums[i] = numbers[i] + "";
//        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));//升序
        Arrays.sort(nums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));//降序
        String ret = "";
        for (String str : nums)
            ret += str;
        return ret;
    }

}
