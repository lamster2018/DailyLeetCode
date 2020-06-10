package Shu;

import mode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 每一层，从上到下，横着打印
 */
public class PrintTreeFromTopToBottom {
    public static void main(String[] args) {

    }

    private static List<Integer> printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);//根节点开始
        while (!queue.isEmpty()) {//保证能进入循环
            int cnt = queue.size();//实际上这里就已经记录了每一层有多少个节点
            while (cnt-- > 0) {
                TreeNode t = queue.poll();//先进先出打印
                if (t == null) continue;//当节点为空时，说明已经打印完毕
                result.add(t.value);//否则加入打印序列
                queue.add(t.left);//把这个节点的左右节点入队
                queue.add(t.right);
            }
        }
        return result;
    }
}
