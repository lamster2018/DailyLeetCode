package ZhanDuiLie

import java.util.*

/**
 * 计算总得分，实际上最终都是通过去除无效得分，留下有效得分的记录
 * 所以可以用栈，用数组都可以,kotlin的栈没有top方法
 * https://leetcode-cn.com/problems/baseball-game/
 */
fun main() {
    val score = arrayOf("5", "-2", "4", "C", "D", "9", "+", "+")
    print("result--:" + BaseballGame.calPoints(score))
}

class BaseballGame {
    companion object {
        fun calPoints(ops: Array<String>): Int {
            var res = 0
            var stack = Stack<Int>()
            for (x in ops) {
                when (x) {
                    "+" -> {
                        var a = stack.get(stack.size - 1)
                        stack.pop()
                        var b = stack.get(stack.size - 1)
                        stack.push(a)
                        stack.push(a + b)
                    }
                    "C" -> {
                        stack.pop()
                    }
                    "D" -> {
                        var top = stack.get(stack.size - 1)
                        stack.push(top * 2)
                    }
                    else -> stack.push(x.toInt())
                }
            }
            for (value in stack) {
                res += value
            }
            return res
        }
    }
}