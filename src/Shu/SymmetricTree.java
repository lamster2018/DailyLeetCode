package Shu;

import mode.TreeNode;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
 *
 * 中线对称
 */
public class SymmetricTree {
    public static void main(String[] args) {

    }

    private static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    //递归三步，终止条件，两个节点同时为null，说明相等，且遍历完。两个节点，不同时为null，说明不是对称的。节点值不一样，说明不对称。
    //操作，操作节点的下一个节点，（左节点的左边，右节点的右边）做对称比较，（左节点的右边，右节点的左边）做对称比较
    private static boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }
}
