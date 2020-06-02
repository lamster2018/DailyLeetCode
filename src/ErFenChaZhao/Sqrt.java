package ErFenChaZhao;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(getSqrt(1024));
    }

    //二分
    private static int getSqrt(int n) {
        int low = 1, high = n, mid = 0;
        while (low <= high) {
            mid = (low + high) >>> 1;//用右移而不是除法
            if (n / mid < mid) high = mid - 1;
            else if (n / (mid + 1) > mid) low = mid + 1;//由于结果要求整数，会存在取整的问题，要处理好
            else return mid;
        }
        return 0;
    }

    private static int binarySearch(Integer[] srcArray, int des) {
        //定义初始最小、最大索引
        int start = 0;
        int end = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (start <= end) {
            //计算出中间索引值
            int middle = (end + start) >>> 1;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                end = middle - 1;
                //判断上限
            } else {
                start = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }
}
