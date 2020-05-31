package DongTaiGuiHua;

/**
 * 连续子数组的最大和
 * 输入一个无序的整数数组，求一个子数组，该子数组的和值最大
 * 时间要求On，空间要求O1
 */
public class FindChildArrayMaxValue {
    public static void main(String[] args) {
        int[] arr = new int[]{-10, 3, -2, -2, 3, -2, 5, 6, -1};
        System.out.println("" + getMaxValue(arr));
        System.out.println("" + getMax2(arr));
    }

    //滑动窗口来求连续
    public static int getMaxValue(int[] arr) {
        if (arr == null) return 0;
        int maxValue = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int window = 1; i + window < len; window++) {
                maxValue = Math.max(maxValue, getValue(i, i + window, arr));
            }
        }
        return maxValue;
    }

    //获取区间值
    public static int getValue(int start, int end, int[] arr) {
        int value = 0;
        while (start <= end) {
            value += arr[start];
            start++;
        }
        return value;
    }

    /**
     * https://www.jianshu.com/p/fa1530aafc34
     */
    public static int getMax2(int[] arr) {
        if (arr == null) return 0;
        int max = Integer.MIN_VALUE;
        int pre = 0;//pre用于计算以arr[i]为结尾元素的连续数组的最大和

        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(pre + arr[i], arr[i]);
//            System.out.println("" + pre);
            max = Math.max(max, pre);
//            System.out.println("" + max);
        }
        return max;
    }
}
