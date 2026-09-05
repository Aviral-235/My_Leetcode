import java.util.Stack;

class Solution {
    class Pair {
        int num, pos;
        Pair(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek().num >= arr[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? (i + 1) : (i - st.peek().pos);
            st.push(new Pair(arr[i], i));
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek().num > arr[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? (n - i) : (st.peek().pos - i);
            st.push(new Pair(arr[i], i));
        }

        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) left[i] * right[i];
            long totalContribution = (count % mod * arr[i]) % mod;
            totalSum = (totalSum + totalContribution) % mod;
        }

        return (int) totalSum;
    }
}