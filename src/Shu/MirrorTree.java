package Shu;

import mode.TreeNode;

/**
 * 生成镜像树，其实就是把节点的左右节点交换
 */
public class MirrorTree {
    public static void main(String[] args) {

    }

    //递归三步，终止条件，节点为null，操作：交换左右节点，下一步：子节点的操作
    private static void mirror(TreeNode node) {
        if (node == null) return;
        swap(node);
        mirror(node.left);
        mirror(node.right);
    }

    private static void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}
