/**
 * 测试数据的二维数组，kotlin不是很好声明
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 */
fun main() {
    var array: Array<CharArray> = arrayOf(
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'p', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'R', '.', '.', '.', 'p'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'p', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.')
    )
    print("result--" + AvailableCapturesForRook.numRookCaptures(array))
}

class AvailableCapturesForRook {
    companion object StaticFun {
        fun numRookCaptures(board: Array<CharArray>): Int {
            // 先找R位置
            var x = 0
            var y = 0
            var flag = false
            for (i in board.indices) {
                for (j in board.get(i).indices) {
                    if (board[i][j] == 'R') {
                        x = i
                        y = j
                        flag = true
                        break
                    }
                }
                if (flag) break
            }
            //从车的上下左右开始遍历寻找，直到遇边界、本方象或吃掉对方兵
            var result = 0
            //向上
            for (i in x downTo 0) {
                if (board[i][y] == 'B') {
                    break
                }
                if (board[i][y] == 'p') {
                    result++
                    break
                }
            }
            //向下
            for (i in x..7) {
                if (board[i][y] == 'B') {
                    break
                }
                if (board[i][y] == 'p') {
                    result++
                    break
                }
            }
            //向左
            for (i in y downTo 0) {
                if (board[x][i] == 'B') {
                    break
                }
                if (board[x][i] == 'p') {
                    result++
                    break
                }
            }
            //向右
            for (i in y..7) {
                if (board[x][i] == 'B') {
                    break
                }
                if (board[x][i] == 'p') {
                    result++
                    break
                }
            }
            return result
        }
    }
}