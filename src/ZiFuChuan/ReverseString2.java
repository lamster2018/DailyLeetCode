package ZiFuChuan;

/**
 * Input:
 * S="abcXYZdef"
 * K=3
 * <p>
 * Output:
 * "XYZdefabc"
 * <p>
 * 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"
 */
public class ReverseString2 {
    public static void main(String[] args) {

    }

    private static String LeftRotateString(String str, int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private static void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

}
