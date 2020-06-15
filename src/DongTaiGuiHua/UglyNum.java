package DongTaiGuiHua;

/**
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，
 * 因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 */
public class UglyNum {
    public static void main(String[] args) {

    }

    private static int getN(int N) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int next2 = dp[i2] * 2;//记录上一次乘因子
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));//要从小到大的顺序
            if (dp[i] == next2)
                i2++;//因为丑数很可能是，2，3，4，5，这个四就绕开了因子3跟5，是2的自乘，也就是上一次还是乘2
            if (dp[i] == next3)
                i3++;
            if (dp[i] == next5)
                i5++;
        }
        return dp[N - 1];
    }
}
