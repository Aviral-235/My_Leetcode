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
    public void all_paths(TreeNode root,int targetSum,List<Integer> list,List<List<Integer>> ans){
        if(root==null){
            return;
        }
         list.add(root.val);
        if(root.right==null&&root.left==null){
            if(targetSum-root.val==0){
                ans.add(new ArrayList<>(list));
            }
        }
            if(root.left!=null){
                all_paths(root.left,targetSum-root.val,list,ans);
            }
            if(root.right!=null){
               
                all_paths(root.right,targetSum-root.val,list,ans);
            }
            if(list.size()>0){
                list.remove(list.size()-1);
            }
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        all_paths(root,targetSum,new ArrayList<>(),ans);
        return ans;
    }
}