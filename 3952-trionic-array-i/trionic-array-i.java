class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false; 
        
        int i = 0;

        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        
    
        if (i == 0 || i == n - 1) return false;

       
        int peak1 = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) i++;
        
        
        if (i == peak1 || i == n - 1) return false;

   
        int valley = i;
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;

       
        return i == n - 1 && i > valley;
    }
}