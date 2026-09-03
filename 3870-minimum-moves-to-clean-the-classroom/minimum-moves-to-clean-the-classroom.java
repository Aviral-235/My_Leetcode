import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int sr = -1;
        int sc = -1;
        int m = classroom.length;
        int n = classroom[0].length();
        int litterCount = 0;
        int[][] arr = new int[m][n];
        for (int[] row : arr) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    arr[i][j] = litterCount++;
                }
            }
        }

        int maxMask = (1 << litterCount) - 1;
        int masks = 1 << litterCount;
        int[][][] best = new int[m][n][masks];
        for (int[][] edge : best) {
            for (int[] row : edge) {
                Arrays.fill(row, -1);
            }
        }

        class State {
            int r, c, mask, en, dist;
            State(int r, int c, int mask, int en, int dist) {
                this.r = r;
                this.c = c;
                this.mask = mask;
                this.en = en;
                this.dist = dist;
            }
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(sr, sc, 0, energy, 0));
        best[sr][sc][0] = energy;
        int[][] dirc = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        while (!q.isEmpty()) {
            State curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int mask = curr.mask;
            int en = curr.en;
            int dist = curr.dist;

            if (mask == maxMask) {
                return dist;
            }
            if (en == 0) {
                continue;
            }

            for (int[] dir : dirc) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) { // 
                    continue;
                }
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newen = en - 1;
                int newMask = mask;
                char cell = classroom[nr].charAt(nc);

                if (cell == 'L') {
                    newMask |= (1 << arr[nr][nc]);
                }
                if (cell == 'R') {
                    newen = energy;
                }

                if (best[nr][nc][newMask] >= newen) {
                    continue;
                }

                best[nr][nc][newMask] = newen;
                q.add(new State(nr, nc, newMask, newen, dist + 1));
            }
        }
        return -1;
    }
}