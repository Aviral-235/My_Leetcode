class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
if (rows == 0) return;
int cols = board[0].length;

for (int i = 0; i < cols; i++) {
    if (board[0][i] == 'O') {
        dfs(board, 0, i);
    }
    if (rows > 1 && board[rows - 1][i] == 'O') {
        dfs(board, rows - 1, i);
    }
}

for (int i = 1; i < rows - 1; i++) {
    if (board[i][0] == 'O') {
        dfs(board, i, 0);
    }
    if (cols > 1 && board[i][cols - 1] == 'O') {
        dfs(board, i, cols - 1);
    }
}
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public static void dfs(char grid[][],int r,int c){
        if(r<0||r>grid.length-1||c<0||c>grid[0].length-1||grid[r][c]!='O'){
            return ;
        }
        grid[r][c]='#';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}