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
     Map<Integer,Integer> count=new HashMap<>();
    int maxcount=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res=new ArrayList<>();
        for(int s:count.keySet()){
            if(count.get(s)==maxcount){
                res.add(s);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int s=dfs(root.left)+dfs(root.right)+root.val;
        count.put(s,count.getOrDefault(s,0)+1);
        maxcount=Math.max(maxcount,count.get(s));
        return s;
    }
}