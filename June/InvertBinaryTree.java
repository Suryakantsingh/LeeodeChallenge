/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
       if(root == null)
              return null;
          
           TreeNode temp = root.right;
          root.right = subTree(root.left);
          root.left = subTree(temp);
          return root;
    }
    public TreeNode subTree(TreeNode root){
        if(root == null) {
           return null;
        }
        
        if(root.left != null && root.right != null){
             TreeNode temp1 = root.right;
            root.right = root.left;
            root.left = temp1;

        }else{
            if(root.left != null){
                TreeNode temp = root.left;
                root.right = temp;
                root.left = null;
            }else {
                if (root.right != null) {
                     TreeNode temp = root.right;
                     root.left = temp;
                     root.right = null;
                }
            }
        }
        subTree(root.left);
        subTree(root.right);
        return root;
    }
}
     
