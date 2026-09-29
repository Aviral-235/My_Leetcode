class Solution {
    public boolean hasValidPath(char[][] grid) {
        int count= (grid.length+grid[0].length)/2;
        if(grid[0][0]==')'){
            return false;
        }
        Boolean dp[][][]=new Boolean[grid.length][grid[0].length][count+1];
        return solve(grid,0,0,0,dp,count); 
    }
    public boolean solve(char grid[][],int r,int c,int count,Boolean dp[][][],int maxct){
        if(r>=grid.length||c>=grid[0].length){
            return false;
        }
        if(r==grid.length-1&&c==grid[0].length-1){
            if(grid[r][c]=='('){
                return false;
            }
            count--;
            return count==0;
        }
        if(count<0||count>maxct){
            return false;
        }
        
        if(dp[r][c][count]!=null){
            return dp[r][c][count];
        }
        char ch=grid[r][c];
        boolean down=false;
        if(ch=='('){
            down=solve(grid,r+1,c,count+1,dp,maxct);
        }
        else{
            down=solve(grid,r+1,c,count-1,dp,maxct);
        }
        boolean right=false;
        if(ch=='('){
            right=solve(grid,r,c+1,count+1,dp,maxct);
        }
        else{
            right=solve(grid,r,c+1,count-1,dp,maxct);
        }
        return dp[r][c][count]=down||right;
    }
}