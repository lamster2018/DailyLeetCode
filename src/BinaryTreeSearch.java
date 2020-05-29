import mode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreeSearch {
    public static void main(String[] args) {
        post(0, 0, preArr.length - 1);
        System.out.println("\n");
        pre(5, 0, postArr.length - 1);
    }

    private static int[] preArr = new int[]{1, 2, 4, 5, 3, 6};
    private static int[] midArr = new int[]{4, 2, 5, 1, 3, 6};
    private static int[] postArr = new int[]{4, 5, 2, 6, 3, 1};

    //已知先，中，求后序
    public static void post(int root, int start, int end) {
        if (start > end) return;
        int i = start;
        while (i < end && midArr[i] != preArr[root]) i++;  //定位根在中序的位置
        post(root + 1, start, i - 1);  //递归处理左子树
        post(root + 1 + i - start, i + 1, end);  //递归处理右子树
        System.out.print(" " + midArr[i]);//后序的输出是最后
    }

    //已知中，后，求先序
    public static void pre(int root, int start, int end) {
        if (start > end) return;
        int i = start;
        while (i < end && midArr[i] != postArr[root]) i++;  //定位根在中序的位置
        System.out.print(" " + midArr[i]);//先序的就先输出访问
        pre(root - 1 - (end - i), start, i - 1);  //递归处理左子树
        pre(root - 1, i + 1, end);  //递归处理右子树
    }

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

    // 递归先序遍历
    public static void recursionPreOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            recursionPreOrderTraversal(root.left);
            recursionPreOrderTraversal(root.right);
        }
    }

    // 非递归先序遍历
    public static void preOrderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Deque<TreeNode> treeNodeStack = new LinkedList<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.value + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    // 递归中序遍历
    public static void recursionMiddleOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleOrderTraversal(root.left);
            System.out.print(root.value + " ");
            recursionMiddleOrderTraversal(root.right);
        }
    }

    // 非递归中序遍历
    public static void middleOrderTraversal(TreeNode root) {
        Deque<TreeNode> treeNodeStack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.value + " ");
                node = node.right;
            }
        }
    }

    // 递归后序遍历
    public static void recursionPostOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostOrderTraversal(root.left);
            recursionPostOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    // 非递归后序遍历
    public static void postOrderTraversal(TreeNode root) {
        Deque<TreeNode> treeNodeStack = new LinkedList<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.value + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }
}

