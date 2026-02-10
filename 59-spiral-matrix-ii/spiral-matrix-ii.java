import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][]=new int [n][n];
        int top = 0;
        int left = 0;
        int right =  n - 1;
        int bottom = n - 1;
        int j=1;
        while (bottom >=top && right >= left) {
            for (int i = left; i <= right; i++) {
                arr[top][i]=j;
                j++;
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                arr[i][right]=j;
                j++;
            }
            right--;
             if(bottom>=top){
            for (int i = right; i >= left; i--) {
                arr[bottom][i]=j;
                j++;
            }}
            bottom--;
            if(right>=left){
            for (int i = bottom; i >= top; i--) {
                arr[i][left]=j;
                j++;
            }}
            left++;
        }
        return arr;
    }
}
