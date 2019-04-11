public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("" + reverse(-1230));
    }

    /**
     * 反转int
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = x % 10 + result * 10;
            x = x / 10;
        }
        return result;
    }
}
