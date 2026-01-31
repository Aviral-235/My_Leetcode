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
    public static boolean findpath(TreeNode root,List<TreeNode>temp,int n){
        if(root==null){
            return false;
        }
        temp.add(root);
        if(root.val==n){
            return true;
        }
        if(findpath(root.right,temp,n)||findpath(root.left,temp,n)){
            return true;
        }
            temp.remove(temp.size()-1);
            return false;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p1= new ArrayList<>();
        List<TreeNode> p2= new ArrayList<>();
        if(findpath(root,p1,p.val)==false||findpath(root,p2,q.val)==false){
            return null;
        }
        int i=0;
       while (i < p1.size() && i < p2.size() && p1.get(i) == p2.get(i)) {
            i++;
        }
        
        return p1.get(i-1);
    }
}