import kotlin.coroutines.coroutineContext

fun main() {
    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    print("result:" + ContainerWithMostWater.maxArea(height))
    print("result:" + ContainerWithMostWater.maxAreaGD(height))
}

class ContainerWithMostWater {
    companion object {
        //暴力双循环，不断的去尝试所有的组合
        fun maxArea(height: IntArray): Int {
            var area = 0
            for (i in height.indices) {
                for (j in 1 until height.size) {
                    var high = Math.min(height[i], height[j])
                    area = Math.max(area, high * (j - i))
                }
            }
            return area
        }

        fun maxAreaGD(height: IntArray): Int {
            var area = 0
            var left = 0
            var right = height.size - 1
            while (left < right) {
                var high = Math.min(height[left], height[right])
                area = Math.max(area, high * (right - left))
                //思路重点，缩进长边，不会让面积更大，所以选择缩进短边去尝试，做到局部最右
                if (height[left] < height[right]) {
                    left++
                } else {
                    right--
                }
            }
            return area
        }
    }
}