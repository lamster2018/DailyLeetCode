package Shu;

import mode.TreeNode;

import java.util.ArrayList;

/**
 * 找二叉树的第k个节点
 * 二叉查找树，二叉搜索树，的特点，左边节点都比跟节点小，右节点都比左节点大
 * <p>
 * 利用中序遍历的有序性来做这个事
 * <p>
 * 第k个或者第k大个节点，直接用中序求
 * <p>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class BinaryTreeKNode {
    public static void main(String[] args) {

    }

    private static int cnt = 0;
    private static TreeNode result;

    private static TreeNode KthNode(TreeNode root, int k) {
        findK(root, k);
        return result;
    }

    private static void findK(TreeNode node, int kth) {
        if (node == null || cnt >= kth) return;
        findK(node.left, kth);
        cnt++;
        if (cnt == kth) result = node;
        findK(node.right, kth);
    }

    //如果是第k小，可以拿个arrayList存下来
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    //我认为可以逆中序遍历，cnt--
    private static TreeNode finkSmall(TreeNode root, int k) {
        cnt = k;
        findKSmallest(root);
        return result;
    }

    private static void findKSmallest(TreeNode node) {
        if (node == null || cnt == 0) return;
        findKSmallest(node.right);
        cnt--;
        if (cnt == 0) result = node;
        findKSmallest(node.left);
    }
}
