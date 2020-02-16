/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 这题的重点是，如何配对，然后去重，解题思路，排序后，小的在左，大的在右，大0的就右指针右移,小0的左指针左移
 * https://leetcode-cn.com/problems/3sum/
 */
fun main() {
    val test = intArrayOf(-1, 0, 1, 2, -1, -4)
    print("result:" + (ThreeSum.threeSum(test)?.size ?: 0))
}

class ThreeSum {
    companion object {
        fun threeSum(nums: IntArray?): List<List<Int>>? {
            if (nums == null || nums.size < 3) return null
            var n = nums.size
            var result = ArrayList<ArrayList<Int>>()
            nums.sort()
            var L = 0
            var R = n
            for (i in nums.indices) {
                if (nums[i] > 0) return result
                if (i > 0 && nums[i] == nums[i - 1]) {//去除重复组合
                    //存在 [-1,-1,2,2]这样的组合，第一个-1已经计算了一次，后一个-1实际上可以跳过
                    continue
                }
                //左右双指针
                L = i + 1
                R = n - 1
                while (L < R) {
                    if (nums[i] + nums[L] + nums[R] == 0) {
                        var res: ArrayList<Int> = arrayListOf(nums[0], nums[L], nums[R])
                        result.add(res)
                        while (L < R && nums[L] == nums[L + 1]) {//移动左指针，去重
                            L++
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--
                        }
                        R--
                        L++
                    } else if (nums[i] + nums[L] + nums[R] > 0) {
                        // 如果结果大于0，说明右边的数大了
                        R--
                    } else {
                        L++
                    }
                }
            }
            return result
        }
    }
}