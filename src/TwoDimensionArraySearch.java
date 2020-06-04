/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 * <p>
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
 * 因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，
 * 当前元素的查找区间为左下角的所有元素
 */
public class TwoDimensionArraySearch {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 16;
        int targetN = 101;
        System.out.println("" + find(matrix, target));
        System.out.println("" + find(matrix, targetN));
    }

    private static boolean find(int[][] matrix, int target) {
        for (int i = 0, j = matrix[i].length - 1; i < matrix.length || j <= 0; ) {
            if (target == matrix[i][j]) return true;
            else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
