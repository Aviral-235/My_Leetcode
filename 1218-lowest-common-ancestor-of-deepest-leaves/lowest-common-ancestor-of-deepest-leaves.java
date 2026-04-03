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
    public int maxdepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxdepth(root.right),maxdepth(root.left));
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return find(root,maxdepth(root),0);
    }
    public TreeNode find(TreeNode root,int maxd,int len){
        if(root==null){
            return null;
        }
        if(maxd-1==len){
            return root;
        }
        TreeNode left=find(root.left,maxd,len+1);
        TreeNode right=find(root.right,maxd,len+1);
        if(left!=null&&right!=null){
            return root;
        }
        if(left!=null&&right==null){
            return left;
        }
        else{
            return right;
        }
    }
}