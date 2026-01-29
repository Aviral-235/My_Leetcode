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
    private int pre_idx=0;
    public  TreeNode problem(int[]pre,int[]in,int is,int ie){
        if(is>ie){
            return null;
        }
        TreeNode root= new TreeNode(pre[pre_idx++]);
        
        int idx=0;
        for(int i=is;i<=ie;i++){
            if(in[i]==root.val){
                idx=i;
                break;
            }
        }
        root.left=problem(pre,in,is,idx-1);
        root.right=problem(pre,in,idx+1,ie);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre_idx=0;
        return problem(preorder,inorder,0,preorder.length-1);
    }
}