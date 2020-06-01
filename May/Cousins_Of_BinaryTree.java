package leetCodeChallenge.may;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cousins_Of_BinaryTree {
    static TreeNode root;

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
            left = right = null;
        }
    }

    boolean result = false;
    int initial = 0;
    int last = 0;

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null)
            return false;
        if (root.val == x || root.val == y) {
            return false;
        }
        initial = x;
        last = y;

        treeTraversal(root);
        return result;
    }

    public void treeTraversal(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        Queue<Integer> balance = new LinkedList<>();
        balance.add(root.val);

        while (!queue.isEmpty()) {

            int length = queue.size();

            if (balance.contains(initial) && balance.contains(last)) {
                result = true;
                return;
            } else {
                if (balance.contains(initial) || balance.contains(last)) {
                    result = false;
                    return;
                }
            }
            while (length > 0) {
                ArrayList list = new ArrayList();

                TreeNode temp = queue.poll();
                int i = balance.poll();

                if (temp.left != null) {
                    queue.add(temp.left);
                    list.add(temp.left.val);
                    balance.add(temp.left.val);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    list.add(temp.right.val);
                    balance.add(temp.right.val);
                }
                if(list.contains(initial) && list.contains(last)){
                    result = false;
                    return;
                }
                length--;
            }
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Cousins_Of_BinaryTree tree = new Cousins_Of_BinaryTree();
        System.out.println(tree.isCousins(root, 5, 4));
    }
}
