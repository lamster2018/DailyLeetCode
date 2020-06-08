package PaiXu;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 3, 5, 2, 7, 6, 6, 2};
//        for (int i : bubble1(arr)) {
        for (int i : standardBubble(arr)) {
            System.out.println("" + i);
        }
    }

    private static int[] bubble1(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (arr[i] > arr[j]) {//升序
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        return arr;
    }

    private static int[] standardBubble(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++)
            for (int j = n - 1; j >= i; j--) {
                if (arr[j] > arr[j - 1]) { //降序
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        return arr;
    }
}
