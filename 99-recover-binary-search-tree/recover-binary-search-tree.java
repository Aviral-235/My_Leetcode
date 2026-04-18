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
    public void value(TreeNode root,List<Integer> list){
        if(root!=null){
            value(root.left,list);
            list.add(root.val);
            value(root.right,list);
        }
    }
        int i=0;
        public void final_(TreeNode root,List<Integer> list){
            if(root!=null){
                final_(root.left,list);
                root.val=list.get(i);
                i++;
                final_(root.right,list);
            }
        }
    public void recoverTree(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        value(root,list);
        Collections.sort(list);
        final_(root,list);
        }

       
    }
