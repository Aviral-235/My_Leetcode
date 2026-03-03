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
 import java.util.*;
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode res=new TreeNode(0);
        while(q.isEmpty()==false){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(i==0){
                    res=temp;
                }
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                    
            }
        }
        return res.val;
    }
}