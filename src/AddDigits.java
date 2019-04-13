/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决
 * https://leetcode-cn.com/problems/add-digits/
 */
public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(98));
        System.out.println(addDigits2(98));
    }

    /**
     * 除了传统的单纯循环，还可以找规律。
     * 假如一个三位数'abc'，其值大小为s1 = 100 * a + 10 * b + 1 * c，
     * 经过一次各位相加后，变为s2 = a + b + c，减小的差值为(s1 -s2) = 99 * a + 9 * b，
     * 差值可以被9整除，每一个循环都这样，缩小了9的倍数。
     * 当num小于9，即只有一位时，直接返回num，
     * 大于9时，如果能被9整除，则返回9（因为不可能返回0也不可能返回两位数及以上的值），
     * 如果不能被整除，就返回被9除的余数。
     * <p>
     * 这个数学规律方法，我想不到....
     *
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        if (num > 9) {
            num = num % 9;
            if (num == 0) return 9;
        }
        return num;
    }

    public static int addDigits2(int num) {
        if (num <= 9) return num;
        int sum = 0;
        while (num != 0) {
            sum = sum + num % 10;
            num /= 10;
        }
        return addDigits2(sum);
    }
}
