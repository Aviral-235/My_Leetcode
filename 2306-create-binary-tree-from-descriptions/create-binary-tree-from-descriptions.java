class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] arr = new TreeNode[100001];
        boolean[] hasParent = new boolean[100001];
        
        for (int i = 0; i < descriptions.length; i++) {
            int parentVal = descriptions[i][0];
            int childVal = descriptions[i][1];
            int isLeft = descriptions[i][2];
            
            if (arr[parentVal] == null) {
                arr[parentVal] = new TreeNode(parentVal);
            }
            if (arr[childVal] == null) {
                arr[childVal] = new TreeNode(childVal);
            }
            
            if (isLeft == 1) {
                arr[parentVal].left = arr[childVal];
            } else {
                arr[parentVal].right = arr[childVal];
            }
            
            hasParent[childVal] = true;
        }
        
        for (int i = 0; i < descriptions.length; i++) {
            int parentVal = descriptions[i][0];
            if (!hasParent[parentVal]) {
                return arr[parentVal];
            }
        }
        
        return null;
    }
}