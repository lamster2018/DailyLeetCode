/**
 * 打印从 1 到最大的 n 位数
 * 数字很大，所以不能直接用int来，可能超范围
 */
public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        int n = 2;
        print1ToMaxOfNDigits(n);
    }

    private static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private static void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');// 循环把  0~9 存到 第 digit位
            print1ToMaxOfNDigits(number, digit + 1);//digit不会自加
        }
    }

    private static void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);//按位打印char数组里的值
        System.out.println();
    }
}
