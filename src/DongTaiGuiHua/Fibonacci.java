package DongTaiGuiHua;

/**
 * 类似问题
 * 1.一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 2.我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 *
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("" + getFibonacciN(6));
    }

    /**
     * 求斐波那契数列的第 n 项，n <= 39。
     */
    private static int getFibonacciN(int n) {
        if (n <= 1) return n;
        int fn_2 = 0, fn_1 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}
