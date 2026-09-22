class Solution {
    public long[] resultArray(int[] nums, int k) {
        long res[]=new long[k];
        long prev_ct[]=new long[k];
        for(int i=0;i<nums.length;i++){
            long curr_ct[]=new long[k];
            int self_rem = nums[i] % k;
            curr_ct[self_rem]++;
            for(int j=0;j<k;j++){
                int new_rem= (int)(((long)j*(nums[i]%k))%k);
                curr_ct[new_rem]+=prev_ct[j];
            }
            System.arraycopy(curr_ct, 0, prev_ct, 0, curr_ct.length);
            for(int p=0;p<k;p++){
                res[p]+=prev_ct[p];
            }
        }
        return res;
    }
}