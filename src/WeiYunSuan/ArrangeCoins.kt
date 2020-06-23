package WeiYunSuan

import kotlin.math.sqrt

/**
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * https://leetcode-cn.com/problems/arranging-coins/
 */
fun main() {
    print("result---" + ArrangeCoins.arrangeCoinsByMath(5050))
    print("result---" + ArrangeCoins.arrangeCoinsByIteration(5050))
}

class ArrangeCoins {
    companion object {
        @JvmStatic
        fun arrangeCoinsByMath(n: Int): Int {
            if (n < 0) return 0
            if (n == 1) return 1
            return ((-1 + sqrt(1 + 8 * n.toDouble())) / 2).toInt()
        }

        @JvmStatic
        fun arrangeCoinsByIteration(n: Int): Int {
            if (n < 0) return 0
            var k = 1
            var num = n
            while (num - k > k) {
                num -= k
                k++
            }
            return k
        }
    }
}