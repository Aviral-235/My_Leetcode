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
    int sum=0;
    public int dfs(TreeNode root,int num){
        if(root==null){
            return 0;
        }
        num*=10;
        num+=root.val;
        if(root.left==null&&root.right==null){
            return sum+=num;
        }
        if(root!=null){
            dfs(root.left,num);
            dfs(root.right,num);
        }
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
}