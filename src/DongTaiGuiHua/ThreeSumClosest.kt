package DongTaiGuiHua

import kotlin.math.abs

/**
 * 三数的问题，还是借鉴三数和的思路，通过双指针的方式，向中间逼近
 * https://leetcode-cn.com/problems/3sum-closest/
 */
fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    val target = -7
    print("result:" + (ThreeSumClosest.threeSumClosest(nums, target)))
}

class ThreeSumClosest {
    companion object {
        fun threeSumClosest(nums: IntArray, target: Int): Int {
            var closestSum = 0
            if (nums == null || nums.size < 3) return closestSum
            nums.sort()
            var n = nums.size
            var L = 0
            var R = n
            var temp = 0
            for (i in nums.indices) {
                L = i + 1
                R = n - 1
                while (L < R) {
                    temp = nums[L] + nums[i] + nums[R]
                    if (abs(temp - target) < abs(closestSum - target)) {
                        closestSum = temp
                    }
                    if (temp > target) {
                        R--
                    } else if (temp < target) {
                        L++
                    } else {
                        closestSum = target
                        return closestSum
                    }
                }
            }
            return closestSum
        }
    }
}