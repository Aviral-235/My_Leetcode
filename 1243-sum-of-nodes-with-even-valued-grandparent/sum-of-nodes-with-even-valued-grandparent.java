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
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int sum=0;
        while(q.isEmpty()==false){
            TreeNode c=q.poll();
            if(c.val%2==0&&c.right!=null){
                if(c.right.right!=null){
                    sum+=c.right.right.val;
                }
                if(c.right.left!=null){
                    sum+=c.right.left.val;
                }
            }
            if(c.val%2==0&&c.left!=null){
                if(c.left.right!=null){
                    sum+=c.left.right.val;
                }
                if(c.left.left!=null){
                    sum+=c.left.left.val;
                }
            }
            if(c.right!=null){
                q.add(c.right);
            }
            if(c.left!=null){
                q.add(c.left);
            }
        }
        return sum;
    }
}