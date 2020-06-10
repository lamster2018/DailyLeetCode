package Shu;

import mode.TreeNode;

/**
 * 树的子结构，树的匹配问题
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 * 若树 B 是树 A 的子结构，则子结构的根节点可能为树 A 的任意一个节点。因此，判断树 B是否是树 A的子结构，需完成以下两步工作：
 * <p>
 * 先序遍历树 A 中的每个节点 An（对应函数 isSubStructure(A, B)）
 * 判断树 A 中 以 An 为根节点的子树 是否包含树 B 。（对应函数 recur(A, B)）
 */

public class SubTree {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //树 A 的根节点记作 节点 A ，树 B 的根节点称为 节点 B
    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true; //当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true
        if (A == null || A.val != B.val) return false; //当节点 A 为空：说明已经越过树 AA 叶子节点，即匹配失败，返回 false，因为节点A已经跑完了
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


}
