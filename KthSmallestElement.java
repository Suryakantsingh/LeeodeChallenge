/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
*/

package leetCodeChallenge.may;

public class KthSmallestElement {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            this.data = d;
            left = right = null;
        }
    }
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        kthSmallest(root.left,k);
        count++;
        if(count == k){
            result = root.data;
        }
        kthSmallest(root.right,k);
        return result;
    }


    public static void main(String[] args) {
        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        KthSmallestElement tree = new KthSmallestElement();
        System.out.println(tree.kthSmallest(root,3));
    }
}
