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
    int preindex=0;
    public TreeNode cTree(int[]in,int[]post,int is,int ie){
        if(is>ie){
            return null;
        }
        TreeNode root=new TreeNode(post[preindex--]);
        int idx=0;
        for(int i=is;i<=ie;i++){
            if(in[i]==root.val){
                idx=i;
                break;
            }
        }
        root.right=cTree(in,post,idx+1,ie);
        root.left=cTree(in,post,is,idx-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        preindex=postorder.length-1;
        return cTree(inorder,postorder,0,inorder.length-1);
    }
}