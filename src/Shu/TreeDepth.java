package Shu;

import mode.TreeNode;

public class TreeDepth {
    public static void main(String[] args) {

    }

    private static int getDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
