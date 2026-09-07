import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int ast : asteroids) {
            boolean exploded = false;

            // Handle collision: stack top moving right (> 0) and current moving left (< 0)
            while (!st.isEmpty() && st.peek() > 0 && ast < 0) {
                if (st.peek() < -ast) {
                    st.pop(); // Stack top explodes, keep checking previous stack elements
                } else if (st.peek() == -ast) {
                    st.pop(); // Both destroy each other
                    exploded = true;
                    break;
                } else {
                    exploded = true; // Current asteroid explodes
                    break;
                }
            }

            if (!exploded) {
                st.push(ast);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}