/**
 * 有两种特殊字符。第一种字符可以用一比特0来表示。
 * 第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。
 * 问最后一个字符是否必定为一个一比特字符。
 * 给定的字符串总是由0结束。
 *
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 */
public class IsOneBitCharacter {
    public static void main(String[] args) {
//        int[] test = new int[]{1, 0, 0};
        int[] test = new int[]{1, 1, 1, 0};
//        int[] test = new int[]{0, 1, 1, 0};
        System.out.println("" + isOneBitCharacter(test));
    }

    /**
     * 要确保最后一个字符是一比特0
     * 要确定倒数第二个不是1
     * 实际上读到1，无论后一位是什么，都是一个 二比特，可以跳过
     * 所以从头读，读到1就跳过下一个
     * 当index能够读到最后一位，则说明满足条件了
     *
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int index = 0;
        while (index < len) {
            if (index == len - 1) return true;
            if (bits[index] == 1) index += 2;
            else index++;
        }
        return false;
    }
}
