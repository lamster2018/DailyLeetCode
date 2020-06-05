package ErFenChaZhao;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 7, 7, 7, 8, 1, 2};
        System.out.println("" + getValue(arr));
    }

    // 数组的前半部是 非递减数组，也就是说，非递减数组的最后一个一定是大于等于该部分的第一个
    // 这里利用的是 二分法，对半查找分界点
    private static int getValue(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (high - low) / 2 + low;
            if (arr[mid] >= arr[low]) {//二分法的坑点在处理边界
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[mid];
    }
}
