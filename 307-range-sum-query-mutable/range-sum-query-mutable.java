class NumArray {
        private int nums[];
        private int n;
        private int tree[];
    public NumArray(int[] nums) {
        this.nums=nums;
        this.n=nums.length;
        this.tree=new int[n+1];

        for(int i=0;i<n;i++){
            initupdate(i+1,nums[i]);
        }
    }
    
    public void update(int index, int val) {
       int delta=val-nums[index];
       nums[index]=val;
       int treeIdx=index+1;
       while (treeIdx <= n) {
            tree[treeIdx] += delta;
            treeIdx += treeIdx & (-treeIdx);
        }
    }
    
    public void initupdate(int treeIdx,int val){
        while (treeIdx <= n) {
            tree[treeIdx] += val;
            treeIdx += treeIdx & (-treeIdx);
        }
    }

    private int query(int treeIdx) {
        int sum = 0;
        while (treeIdx > 0) {
            sum += tree[treeIdx];
            treeIdx -= treeIdx & (-treeIdx);
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return query(right+1)-query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */