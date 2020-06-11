package Shu;

import mode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径(也就是说必须到子节点尽头）
 * <p>
 * 实际是一个先序遍历
 */
public class TreeSum {
    public static void main(String[] args) {

    }

    private static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

    private static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) return paths;
        getPath(root, target, new ArrayList<>());
        return paths;
    }

    //递归，先序遍历
    private static void getPath(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) return;//递归终止条件
        path.add(node.value);//处理当前节点
        target -= node.value;
        if (target == 0 && node.left == null && node.right == null) {
            paths.add(path);
        } else {
            getPath(node.left, target, path);
            getPath(node.right, target, path);//给下一级什么（节点，处理后的target，已经走过的path）
        }
    }
}
