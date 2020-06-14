/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数
 * https://leetcode-cn.com/problems/number-of-digit-one/solution/shu-zi-1-de-ge-shu-by-leetcode/
 * <p>
 * 暴力法很简单，但是耗时非常严重，因为有时间上的浪费，大概是10倍
 */
public class CountDigitOne {
    public static void main(String[] args) {
        System.out.println("" + getCnt(99));
        System.out.println("" + getCount(99));
    }

    /**
     * 数学规律
     * 将 i 从 1 遍历到 n，每次遍历 i 扩大 10 倍：
     * (n/(i*10))*i 表示 (i*10) 位上 ’1’ 的个数。
     * {\min(\max((\text{n mod (i*10)} )-i+1,0),i)} 表示需要额外数的 (i*10)位上 ’1’ 的个数。
     */
    private static int getCount(int n) {
        int count = 0;
        for (int divider = 1; divider < n; divider *= 10) {//每次的步进10倍，计算当前区间的个数，10~99，100~999...
            int cur = n / divider;//当前位，可以理解成抛弃低位，比如99/10,有11，21，31...
            count += (cur + 8) / 10 * divider;
            int low = n % divider;
            count += (cur % 10 == 1 ? low + 1 : 0);
        }
        return count;
    }

    //暴力遍历
    private static int getCnt(int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int tmp = i;
            while (tmp != 0) {//数逐位求1
                cnt += (tmp % 10 == 1) ? 1 : 0;
                tmp /= 10;
            }
        }
        return cnt;
    }
}
