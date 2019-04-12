
/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class AddBinary {
    public static void main(String[] args) {
        String tA = "10";
        String tB = "11";
        System.out.println(addBinary(tA, tB));
    }

    /**
     * 二进制的直接加法，从后往前算，进位用flag进行判断
     * 本算法基于ASCII的计算，如果是1，减去'0'的ASCII码值就是1
     * 如果有进位flag则多加1
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        int lenA = a.length();
        int lenB = b.length();
        if (lenA > lenB) {
            b = getString(b, temp, lenB, lenA);
        } else if (lenA < lenB) {
            a = getString(a, temp, lenA, lenB);
        } else {
            temp.append(a);
        }

        for (int i = temp.length() - 1; i >= 0; i--) {
            int num = 0;
            if (flag) num = (a.charAt(i) - '0') + (b.charAt(i) - '0') + 1;
            else num = (a.charAt(i) - '0') + (b.charAt(i) - '0');
            if (num == 0) {
                result.insert(0, "0");
                flag = false;
            } else if (num == 1) {
                result.insert(0, "1");
                flag = false;
            } else if (num == 2) {
                result.insert(0, "0");
                flag = true;
            } else if (num == 3) {
                result.insert(0, "1");
                flag = true;
            }
        }
        if (flag) result.insert(0, "1");
        return result.toString();
    }

    /**
     * 对短的二进制数进行补位
     *
     * @param a
     * @param temp
     * @param lenA
     * @param lenB
     * @return
     */
    private static String getString(String a, StringBuilder temp, int lenA, int lenB) {
        for (int i = 0, count = lenB - lenA; i < count; i++) {
            temp.append("0");
        }
        temp.append(a);
        a = temp.toString();
        return a;
    }

}
