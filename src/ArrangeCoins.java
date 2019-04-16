/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * <p>
 * https://leetcode-cn.com/problems/arranging-coins/
 */
public class ArrangeCoins {
    public static void main(String[] args) {
        int a = 1804289383;
        System.out.println("" + arrangeCoins(a));
    }

    public static int arrangeCoins(int n) {
        int k = 0;
        while (n > k) {
            k++;
            n = n - k;
        }
        return k;
    }

    /**
     * 数列求和的思想，（首项+末项）* 项数 / 2 = sum
     * 末项和项数都是k，简化一下 （1+k)*k = 2*sum
     * 拆 k^2 + k= 2*sum
     * 最接近的 K平方 ≈ 2倍sum
     *
     * @param n
     * @
     */
//    public static int arrangeCoins2(int n) {
//        int k = (int) ((2 * n)^0.5);
//        if (n < 2 || (1 + k) * k / 2 <= n) {
//            return k;
//        } else
//            return k - 1;
//    }
}
