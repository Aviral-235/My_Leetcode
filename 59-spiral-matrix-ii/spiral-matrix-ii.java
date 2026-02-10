class Solution {
    public int[][] generateMatrix(int n)
    {
        int res[][]=new int[n][n];
        int count=1;

        int rows=0;
        int rowe=n-1;
        int cols=0;
        int cole=n-1;

        while(rows<=rowe && cols<=cole)
        {
            for(int i=cols;i<=cole;i++)
            {
                res[rows][i]=count++;
            }

            for(int i=rows+1;i<=rowe;i++)
            {
                res[i][cole]=count++;
            }

            for(int i=cole-1;i>=cols;i--)
            {
                if(rows<rowe)
                {
                    res[rowe][i]=count++;
                }
            }

            for(int i=rowe-1;i>=rows+1;i--)
            {
                if(cols<cole)
                {
                    res[i][cols]=count++;
                }
            }
            rows++;
            cols++;
            rowe--;
            cole--;
        }
        return res;
    }
}