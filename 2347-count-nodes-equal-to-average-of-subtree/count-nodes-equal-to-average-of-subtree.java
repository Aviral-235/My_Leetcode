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
    public int averageOfSubtree(TreeNode root) {
        int count=0;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(q.isEmpty()==false){
            TreeNode c=q.poll();
            int avg=sum(c)/no_nodes(c);
            if(avg==c.val){
                count++;
            }
            if(c.right!=null){
                q.add(c.right);
            }
            if(c.left!=null){
                q.add(c.left);
            }
        }
        return count;
    }
    public static int no_nodes(TreeNode root){
        int count=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.isEmpty()==false){
            count++;
            TreeNode temp=q.poll();
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return count;
    }
    public static int sum(TreeNode root){
        int sum=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.isEmpty()==false){
            TreeNode temp=q.poll();
            sum+=temp.val;
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return sum;
    }
}