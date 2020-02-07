/**
 * 是可以很多次交易的，今天卖了今天可以继续买
 * 要做到累计买卖的收益最大
 * 这种类型的题，本质上是找局部最优解，贪心算法思路
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

fun main() {
    val stock = intArrayOf(1, 7, 2, 3, 6, 7, 6, 7)
    print("result----:" + BestTimeToBuyAndSellStock2.maxProfit(stock))
}

class BestTimeToBuyAndSellStock2 {
    companion object {
        fun maxProfit(prices: IntArray): Int {
            var profit = 0
            for (i in 1 until prices.size) {
                //只要今天的价格，比昨天的高，今天就可以卖出，然后今天再买一手
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1]
                }
            }
            return profit
        }
    }
}