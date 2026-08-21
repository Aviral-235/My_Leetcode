import java.util.Arrays;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        
        long low = 1;
        long high = (long) coins[0] * k;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (count(coins, mid) >= k) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public long count(int[] arr, long x) {
        long ans = 0;
        int n = arr.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long multiple = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    multiple = lcm(multiple, arr[i]);
                    bits++;
                    if (multiple > x) {
                        break;
                    }
                }
            }

            if (multiple > x) {
                continue;
            }

            long count = x / multiple;
            if (bits % 2 == 1) {
                ans += count;
            } else {
                ans -= count;
            }
        }
        return ans;
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public long lcm(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a / gcd(a, b) * b);
    }
}