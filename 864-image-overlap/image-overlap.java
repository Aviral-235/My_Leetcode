class Solution {
    public class Pair {
        int rDiff, cDiff;
        
        Pair(int rDiff, int cDiff) {
            this.rDiff = rDiff;
            this.cDiff = cDiff;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return rDiff == pair.rDiff && cDiff == pair.cDiff;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rDiff, cDiff);
        }
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        Map<Pair, Integer> mpp = new HashMap<>();
        
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {
                if (img1[i][j] == 1) {
                    for (int p = 0; p < img2.length; p++) {
                        for (int q = 0; q < img2[0].length; q++) {
                            if (img2[p][q] == 1) {
                                Pair pp = new Pair(p - i, q - j);
                                mpp.put(pp, mpp.getOrDefault(pp, 0) + 1);
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (Map.Entry<Pair, Integer> entry : mpp.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }

        return ans;
    }
}