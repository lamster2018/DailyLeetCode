/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * https://leetcode-cn.com/problems/add-strings/
 */
public class AddStrings {
    public static void main(String[] args) {
        String a = "100";
        String b = "999";
        System.out.println(addStrings(a, b));
    }

    /**
     * 字符串加法、链表加法以及二进制加法之类的都可以转换成char ASCII码去解决
     * 每一位取计算ascii值与'0'的差值，
     * 这里有个好处，就是无所谓两个数的位数是不是一致，或者哪个字符长
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            sb.insert(0, carry % 10);
            carry /= 10;
        }
        return sb.toString();
    }
}
