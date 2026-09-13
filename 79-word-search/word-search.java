class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
          
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(word,board,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(String s,char board[][],int r,int c,int idx){
        if(idx==s.length()){
            return true;
        }
        if(r<0||r>=board.length||c<0||c>=board[0].length||board[r][c]=='*'||board[r][c]!=s.charAt(idx)){
            return false;
        }
        char temp=board[r][c];
        board[r][c]='*';
        boolean found= dfs(s,board,r+1,c,idx+1)||dfs(s,board,r-1,c,idx+1)||dfs(s,board,r,c-1,idx+1)||dfs(s,board,r,c+1,idx+1);
            board[r][c]=temp;
            return found;
    }
}