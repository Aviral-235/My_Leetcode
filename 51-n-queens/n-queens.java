class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char arr[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        backtrack(0,arr,n,ans);
        return ans;
            }
            public void backtrack(int row,char arr[][],int n,List<List<String>> ans){
                if(row==n){
                    ans.add(construct(arr));
                    return;
                }
                for(int col=0;col<n;col++){
                    if(solve(arr,row,col,n)){
                        arr[row][col]='Q';
                        backtrack(row+1,arr,n,ans);
                        arr[row][col]='.';
                    }
                }
            }    
            public boolean solve(char arr[][],int row,int col,int n){
                for(int i=0;i<row;i++){
                    if(arr[i][col]=='Q'){
                        return false;
                    }
                }
                    for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
                        if(arr[i][j]=='Q'){
                            return false;
                        }
                    }
                    for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
                        if(arr[i][j]=='Q'){
                            return false;
                        }
                    }
                    
                
                return true;
            }              
            public List<String> construct(char arr[][]){
                List<String> temp=new ArrayList<>();
                for(char c[]:arr){
                    temp.add(new String(c));
                }
                return temp;
            }                                  
}                           