package ZiFuChuan;

public class ReplaceString {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("A B C");
        System.out.println(replace(s));
    }

    private static String replace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' '){
                str.append("  ");
                //在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。
                // 因为一个空格要替换成三个字符（%20），所以当遍历到一个空格时，需要在尾部填充两个任意字符
            }

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {//P1 P2都是在末尾
            char c = str.charAt(P1--);
            if (c == ' ') {//逆序添加
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
