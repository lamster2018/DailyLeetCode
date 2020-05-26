import mode.TreeNode;

import java.util.ArrayDeque;

public class BinaryTreeSearch {

    //深度遍历，先根节点，左节点，右节点，所以是先序遍历
    public void DepthSearch(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        //这个结构，pop是删除头节点，push是加到头结点，
        // 后进先出
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }

    //广度遍历
    public void levelSearch(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        //remove是删除头结点，add是加到尾节点
        //先进先出
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println("" + node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}

