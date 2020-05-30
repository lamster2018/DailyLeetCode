package DongTaiGuiHua

/**
 * 斐波那契问题
 * f(n) = f(n-1)+f(n-2)
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
fun main() {
    println("" + ClimbingStairs.climbing(10))
    println("" + ClimbingStairs.climbingFN(10))
}

class ClimbingStairs {
    companion object {
        fun climbing(n: Int): Int {
            if (n == 1) return 1
            var f0 = 1
            var f1 = 1
            var tmp = 0
            var count = n;
            while (count-- > 1) {
                tmp = f1
                f1 += f0
                f0 = tmp
            }
            return f1
        }

        /**
         * 能转化为斐波那契的原因
         * 1级楼梯，只有1种上法
         * 2级楼梯，只有2种上法
         * 3级楼梯，就是前两级楼梯上法的和
         * ...
         * 第n级楼梯，就是第n-1级的上法跟 第n-2级上法的和
         */
        fun climbingFN(n: Int): Int {
            if (n == 1) return 1
            var first = 1;
            var second = 2;
            for (i in 3..n) {
                var third = first + second //理解成tmp
                first = second
                second = third
            }
            return second
        }
    }
}