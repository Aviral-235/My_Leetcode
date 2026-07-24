import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }

        int[] u = new int[uniqueSet.size()];
        int idx = 0;
        for (int num : uniqueSet) {
            u[idx++] = num;
        }

        int m = u.length;

        boolean[] hasXor2 = new boolean[2048];
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                hasXor2[u[i] ^ u[j]] = true;
            }
        }

        boolean[] hasXor3 = new boolean[2048];
        for (int v = 0; v < 2048; v++) {
            if (hasXor2[v]) {
                for (int z : u) {
                    hasXor3[v ^ z] = true;
                }
            }
        }

        int count = 0;
        for (boolean present : hasXor3) {
            if (present) {
                count++;
            }
        }

        return count;
    }
}