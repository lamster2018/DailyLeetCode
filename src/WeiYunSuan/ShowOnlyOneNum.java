package WeiYunSuan;


public class ShowOnlyOneNum {
    public static void main(String[] args) {

    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * https://leetcode-cn.com/problems/single-number/
     * <p>
     * 利用 自己跟自己异或 为0的特性，可以消除 出现两次的元素
     * <p>
     */
    private static int getNum(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;//
        }
        return single;
    }

    /**
     * 如果是 每个元素出现3次，那就要构造一个出现3次然后能置0的算法
     * https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/
     *
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            a = ~b & (a ^ num);
            b = ~a & (b ^ num);
        }
        return a;
    }


    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
     * <p>
     * 解题思路
     * 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
     * <p>
     * diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来
     * <p>
     * https://leetcode-cn.com/problems/single-number-iii/solution/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leetcode/
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask ^ x};
    }

}
