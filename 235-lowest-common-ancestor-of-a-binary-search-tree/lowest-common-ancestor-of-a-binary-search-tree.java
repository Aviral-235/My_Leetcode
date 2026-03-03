/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public static boolean findpath(TreeNode root,ArrayList<TreeNode>p,int n){
        if(root==null){
            return false;
        }
        p.add(root);
        if(root.val==n){
            return true;
        }
        if(findpath(root.left,p,n)||findpath(root.right,p,n)){
            return true;
        }
        p.remove(p.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         ArrayList<TreeNode> p1=new ArrayList<>();
         ArrayList<TreeNode> p2=new ArrayList<>();
         if(findpath(root,p1,p.val)==false||findpath(root,p2,q.val)==false){
            return null;
         }   
         int i=0;
         for(i=0;i<p1.size() && i<p2.size();i++){
            if(p1.get(i)!=p2.get(i)){
                break;
            }

         }
            return p1.get(i-1);
    }

}