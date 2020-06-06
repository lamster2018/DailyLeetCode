package DongTaiGuiHua;

/**
 * 算法的整体思路是：
 * <p>
 * n 除 3 的结果为 a，余数是 b
 * 当 b 为 0，直接将 a 个 3 相乘
 * 当 b 为 1，将（a-1）个 3 相乘，再乘以 4
 * 当 b 为 2，将 a 个 3 相乘，再乘以 2
 *
 * https://leetcode-cn.com/problems/integer-break/
 * 有数学证明，但是没看太明白
 * https://cyc2018.github.io/CS-Notes/#/notes/14.%20%E5%89%AA%E7%BB%B3%E5%AD%90
 */

public class IntegerBreak {
    public static void main(String[] args) {
        int n1 = 2;//1
        int n2 = 10;//36
        System.out.println("" + getMax1(n1));
        System.out.println("" + getMax1(n2));

        dp = new int[n1 + 1];
        System.out.println("" + getMax2(n1));
        dp = new int[n2 + 1];
        System.out.println("" + getMax2(n2));

        System.out.println("" + getMax3(n1));
        System.out.println("" + getMax3(n2));
    }

    //暴力递归，这样会重复计算很多f(n-i)
    private static int getMax1(int n) {
        if (n == 2) return 1;
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * getMax1(n - i)));
        }
        return res;
    }

    private static int[] dp;

    //增加dp空间，缓存上一次计算的值
    private static int getMax2(int n) {
        if (n == 2) return 1;
        if (dp[n] != 0) return dp[n];
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * getMax2(n - i)));
        }
        return res;
    }

    private static int getMax3(int n) {
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j * dp[i - j], j * (i - j));
                dp[i] = Math.max(dp[i], temp);
            }
        }
        return dp[n];
    }
}
