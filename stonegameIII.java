class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n + 1];
        int[] suffixSum = new int[n];
        
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return helper(piles, 0, 1, suffixSum, memo);
    }

    private int helper(int[] piles, int i, int M, int[] suffixSum, int[][] memo) {
        if (i >= piles.length) {
            return 0;
        }
        if (i + 2 * M >= piles.length) {
            return suffixSum[i];
        }
        if (memo[i][M] > 0) {
            return memo[i][M];
        }
        
        int maxStones = 0;
        for (int X = 1; X <= 2 * M; X++) {
            maxStones = Math.max(maxStones, suffixSum[i] - helper(piles, i + X, Math.max(M, X), suffixSum, memo));
        }
        
        memo[i][M] = maxStones;
        return maxStones;
    }
}