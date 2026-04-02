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
    public TreeNode cTree(int[]nums,int is,int ie){
        if(is>ie){
            return null;
        }
        int idx=is;
        for(int i=is+1;i<=ie;i++){
            if(nums[i]>nums[idx]){
                idx=i;
            }
        }
        TreeNode root=new TreeNode(nums[idx]);
        root.right=cTree(nums,idx+1,ie);
        root.left=cTree(nums,is,idx-1);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return cTree(nums,0,nums.length-1);
    }   
}