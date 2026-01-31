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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag=true;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.offer(root);
        while(q.isEmpty()==false){
            Deque<Integer> st= new ArrayDeque<>();
              List<Integer> temp=new ArrayList<>();
            int count=q.size();
            for(int i=0;i<count;i++){
              
            TreeNode curr=q.poll();
            if(flag==false){
                st.push(curr.val);
            }
            else{
                temp.add(curr.val);
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
               
            }
            if(flag==false){
               
                while(st.isEmpty()!=true){
                    temp.add(st.pop());
                }
               
            }
             ans.add(temp);
            flag=!flag;
        }
        return ans;
    }
}