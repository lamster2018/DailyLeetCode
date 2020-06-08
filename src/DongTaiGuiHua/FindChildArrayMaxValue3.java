package DongTaiGuiHua;

/**
 * 给一个正整数数组，求最大连续子数组的长度及起点坐标
 *
 * 思路，因为是连续的，固定起点，以window窗口进行自加
 */
public class FindChildArrayMaxValue3 {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 4, 5, 7, 8};
        int[] arr = new int[]{1, 3, 4, 5, 7, 8, 9, 10};
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        findLongest(arr);
    }

    private static void findLongest(int[] arr) {
        int longestStartIdx = 0;
        int longestArrLength = 1;

        int i = 0;
        int len = arr.length - 1;
        int window = 1;
        while (i < len && i + window <= len) {
            if (arr[i + window - 1] + 1 == arr[i + window]) {//如果当前数 == 前一个数+1，则认为连续，window加1
                window++;
                if (window > longestArrLength) {
                    longestStartIdx = i;
                    longestArrLength = window;
                }
            } else {
                if (window > longestArrLength) {
                    longestStartIdx = i;
                    longestArrLength = window;
                }
                i = i + window;//步进移动
                window = 1;//窗口恢复
            }
        }

        while (longestArrLength > 0) {
            System.out.println(" " + (longestStartIdx++));
            longestArrLength--;
        }
    }
}
