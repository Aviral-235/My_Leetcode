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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int flag=0;
        while(q.isEmpty()==false){
            int temp=0;
            int temp_=Integer.MAX_VALUE;
            int size=q.size();
            for(int i=0;i<size;i++){
                if(flag%2==0){
                     TreeNode c=q.poll();
                    if(c.val%2==0||c.val<=temp){
                        return false;
                    }
                    temp=c.val;
                    if(c.left!=null){
                        q.add(c.left);
                    }
                    if(c.right!=null){
                        q.add(c.right);
                    }
                }
                else{
                    TreeNode c=q.poll();
                    if(c.val%2!=0||c.val>=temp_){
                        return false;
                    }
                    temp_=c.val;
                    if(c.left!=null){
                        q.add(c.left);
                    }
                    if(c.right!=null){
                        q.add(c.right);
                    }
                }
            }
            flag++;
        }
        return true;
    }
}