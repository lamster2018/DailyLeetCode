package DongTaiGuiHua

/**
 * DP思想：
 * 记录【今天之前买入的最小值】
 * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
 * 比较【每天的最大获利】，取最大值即可
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */


fun main() {
//    val stock = intArrayOf(7, 1, 5, 3, 6, 4)
    val stock = intArrayOf(7, 6, 4, 3, 1)
    print("result----:" + BestTimeToBuyAndSellStock.maxProfit(stock))
}

class BestTimeToBuyAndSellStock {
    companion object {
        fun maxProfit(prices: IntArray): Int {
            if (prices.size <= 1) return 0
            else {
                var max = 0
                var min = prices[0]
                var len = prices.size - 1
                for (i in 1..len) {
                    max = Math.max(prices[i] - min, max)
                    min = Math.min(prices[i], min)
                }
                return max;
            }
        }
    }
}