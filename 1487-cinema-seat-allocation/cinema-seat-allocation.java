import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reservedByRow = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            reservedByRow.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }
        int cnt = (n - reservedByRow.size()) * 2;
        for (Set<Integer> reserved : reservedByRow.values()) {
            boolean leftBlockOpen = !reserved.contains(2) && !reserved.contains(3) &&
                                    !reserved.contains(4) && !reserved.contains(5);

            boolean rightBlockOpen = !reserved.contains(6) && !reserved.contains(7) &&
                                     !reserved.contains(8) && !reserved.contains(9);

            boolean middleBlockOpen = !reserved.contains(4) && !reserved.contains(5) &&
                                      !reserved.contains(6) && !reserved.contains(7);

            if (leftBlockOpen && rightBlockOpen) {
                cnt += 2;
            } else if (leftBlockOpen || rightBlockOpen || middleBlockOpen) {
                cnt += 1;
            }
        }

        return cnt;
    }
}