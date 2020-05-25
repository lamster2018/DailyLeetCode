/**
 * 荷兰旗问题
 * 红白黑三色球，分别123表示，打乱的一堆数组，要求排序输出
 * 只能一次遍历（时间复杂度On），不能多加入集合（空间复杂度O1）
 * <p>
 * 分别定义三个指针，rindex, gindex, bindex, rindex和gindex初始时指向第一个元素，gindex指向最后一个。
 * rindex始终指向左边第一个非R的元素，它的作用就是当gindex为R时和gindex的元素进行交换。
 * gindex用来遍历数组，当gindex<=bindex时遍历结束。
 * bindex从右边递减始终指向从右边数第一个非B的元素。
 * 当gindex指向的元素是R时，和rindex的元素进行交换，gindex++, rindex++;
 * 当gindex指向的元素是G时，什么都不做，gindex++;
 * 当gindex指向的元素是B时，和bindex指向的元素互换，bindex--;(这一步为什么gindex++，原因请思考这样的数组GBRB)
 * 当遍历完数组之后所有的R都在左边，G在中间，B在右边
 */
public class ThreeBall {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 3, 2, 2, 1, 1, 3, 1, 2, 1};
        for (int i : threeBall(arr)) {
            System.out.println("" + i);
        }
    }

    public static int[] threeBall(int[] balls) {
        int redIndex = 0;
        int whiteIndex = 0;
        int blackIndex = balls.length - 1;
        while (whiteIndex <= blackIndex) {
            if (balls[whiteIndex] == 1) {//如果是红球
                if (redIndex != whiteIndex) {
                    swap(balls, redIndex, whiteIndex);
                }
                redIndex++;
                whiteIndex++;
            } else if (balls[whiteIndex] == 3) {//如果是黑球
                if (blackIndex != whiteIndex) {
                    swap(balls, whiteIndex, blackIndex);
                }
                blackIndex--;
            } else {
                whiteIndex++;
            }
        }
        return balls;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
