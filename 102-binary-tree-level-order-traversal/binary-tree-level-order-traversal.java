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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        q.offer(root);
        q.offer(null);
        while(q.size()>1){
            
            TreeNode curr= q.poll();
            if(curr==null){
                q.offer(null);
                  res.add(new ArrayList<>(temp));
                  temp.clear();
                  continue;
            }
            temp.add(curr.val);
           
          
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        res.add(temp);
        return res;
    }
}