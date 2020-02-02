import java.util.Arrays.sort

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 * 但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，
 * 这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * https://leetcode-cn.com/problems/assign-cookies/
 */
fun main() {
    val child: IntArray = intArrayOf(1, 4, 2, 3)
    val cookie: IntArray = IntArray(3) { 2 }
    print("result---" + FindContentChildren.findContentChildren(child, cookie))
}

class FindContentChildren {
    companion object StaticParams {
        var varible: String = "varible"
        val value: String = "value"
        const val constValue: String = "constValue"

        /**
         * 贪心算法
         * 给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来给满足度比较大的孩子。
        因为满足度最小的孩子最容易得到满足，所以先满足满足度最小的孩子。


        在以上的解法中，我们只在每次分配时饼干时选择一种看起来是当前最优的分配方法，但无法保证这种局部最优的分配方法最后能得到全局最优解。我们假设能得到全局最优解，并使用反证法进行证明，即假设存在一种比我们使用的贪心策略更优的最优策略。如果不存在这种最优策略，表示贪心策略就是最优策略，得到的解也就是全局最优解。

        证明：假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，第 m 个饼干为可以满足该孩子的最小饼干。假设存在一种最优策略，可以给该孩子分配第 n 个饼干，并且 m < n。我们可以发现，经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比最优策略来得大。因此在后续的分配中，贪心策略一定能满足更多的孩子。也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。

        链接：https://leetcode-cn.com/problems/assign-cookies/solution/tan-xin-jie-fa-by-cyc2018/
         */
        fun findContentChildren(child: IntArray, cookie: IntArray): Int {
            child.sort()
            cookie.sort()
            var result = 0
            var i = 0
            var j = 0
            var childSize = child.size
            var cookieSize = cookie.size
            while (i < childSize && j < cookieSize) {//任一数组循环完，结束循环
                if (cookie[j] >= child[i]) {
                    j++
                    i++
                    result++
                } else i++
            }
            return result
        }
    }
}