/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("" + reverse(-1230));
    }

    /**
     * 反转int
     * int有Integer.Max & Min
     * 假设int上限123，反转就是321，越界了
     * 所以要在每一次结果前做判断
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && temp > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10
                    || (result == Integer.MIN_VALUE / 10 && temp < -8))
                return 0;
            result = result * 10 + temp;
        }
        return result;
    }
}
