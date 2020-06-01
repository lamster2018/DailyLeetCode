package WeiYunSuan;

/**
 * 输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOf1Bit {
    public static void main(String[] args) {
        System.out.println("" + get1Nums(0b1000101));
        System.out.println("" + get1Nums2(0b1000101));
    }

    //求数字n 包含 1的个数
    private static int get1Nums(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>>= 1;
        }
        return count;
    }

    // 利用 n & (n - 1) 可以消除最低位 1 的特性
    private static int get1Nums2(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
