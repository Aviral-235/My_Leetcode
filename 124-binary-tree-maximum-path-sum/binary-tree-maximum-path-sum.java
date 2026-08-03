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
    int pathsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return pathsum;
    }
    public int postorder(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=Math.max(0,postorder(root.left));
        int rh=Math.max(0,postorder(root.right));
        int sum=root.val+lh+rh;
        pathsum=Math.max(pathsum,sum);
        return root.val+Math.max(lh,rh);
    }
}