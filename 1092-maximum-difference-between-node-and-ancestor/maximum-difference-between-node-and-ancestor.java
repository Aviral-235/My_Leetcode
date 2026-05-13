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
    int diff=0;
    public int maxdiff(TreeNode root,int max,int min){
         if(root==null){
            diff=Math.max(diff,Math.abs(min-max));
            return diff;
        }
        max=Math.max(max,root.val);
        min=Math.min(min,root.val);
        maxdiff(root.left,max,min);
        maxdiff(root.right,max,min);
        return diff;
    }
    public int maxAncestorDiff(TreeNode root) {
       return maxdiff(root,root.val,root.val);
    }
}