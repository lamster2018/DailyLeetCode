package Shu

import java.util.*

/**
 *
 * 没看懂题目
 * 不过根据测试用例，给来的[3,9,20,15,7]
 * 是中序遍历的树
 * 第0层是3，平均值3，res[0] = 3
 * 拿到左儿子9，右儿子20，取平均值14.5，res[1] = 14.5
 * 看左儿子有没有儿子，继续poll
 * 右儿子有子树，取15，7平均值
 * 思路大概是这么个思路，就不需要进行深度遍历，因为测试用例已经把树进行遍历了
 *
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
fun main() {
    var ti = AverageOfLevelsInBinaryTreeNode(5)
    var v = ti.value
}

class AverageOfLevelsInBinaryTree {
    companion object {
        fun averageOfLevels(root: AverageOfLevelsInBinaryTreeNode?): DoubleArray {
            var res: DoubleArray = DoubleArray(0)
            if (root == null) return res
            var list: LinkedList<AverageOfLevelsInBinaryTreeNode> = LinkedList()
            list.add(root)
            while (list.size != 0) {
                val len: Int = list.size
                var sum = 0.0
                for (i in 0 until len) {
                    val nodeAverageOfLevelsInBinary: AverageOfLevelsInBinaryTreeNode = list.poll()
                    sum += nodeAverageOfLevelsInBinary.value
                    if (nodeAverageOfLevelsInBinary.left != null) {
                        list.add(nodeAverageOfLevelsInBinary.left!!)
                    }
                    if (nodeAverageOfLevelsInBinary.right != null) {
                        list.add(nodeAverageOfLevelsInBinary.right!!)
                    }
                    res[i] = (sum / len)
                }
            }
            return res
        }
    }
}