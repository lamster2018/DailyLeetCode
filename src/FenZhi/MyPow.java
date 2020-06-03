package FenZhi;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * https://leetcode-cn.com/problems/powx-n/
 * <p>
 * 暴力很简单，循环自乘n次，优化思路，2^4 第一次 2*2 第二次实际上就是  4*4 （2*2  *  2*2）
 * 有个坑，n可为负数，实际上就是最后变倒数
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(getPow(2,-4));
        System.out.println(myPow(2,-4));
    }

    //分治思想，转化成分块去处理
    private static double getPow(int x, int n) {
        if (n == 0) return 1;
        double res = getPow(x, n / 2);
        double remainder = n % 2 == 0 ? 1 : (n < 0 ? 1.0d / x : x);
        return res * res * remainder;
    }

    private static double myPow(double x, int n) {
        if(n == 0) return 1;
        return myPow(x * x, n / 2) * (n % 2 == 0 ? 1 : n > 0 ? x : 1 / x);
    }
}
