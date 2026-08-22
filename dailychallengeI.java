class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int m = 0;
        for (int i = 0; i < n; i++) {
            boolean redundant = false;
            for (int j = 0; j < n; j++) {
                if (i != j && coins[i] % coins[j] == 0) {
                    redundant = true;
                    break;
                }
            }
            if (!redundant) {
                coins[m++] = coins[i];
            }
        }

        int numSubsets = 1 << m;
        long[] lcms = new long[numSubsets];
        int[] signs = new int[numSubsets];
        lcms[0] = 1;

        for (int mask = 1; mask < numSubsets; mask++) {
            int bit = Integer.numberOfTrailingZeros(mask);
            int prevMask = mask ^ (1 << bit);
            long prevLcm = lcms[prevMask];
            
            if (prevLcm == -1) {
                lcms[mask] = -1;
            } else {
                long currentLcm = lcm(prevLcm, coins[bit]);
                lcms[mask] = currentLcm;
            }
            signs[mask] = (Integer.bitCount(mask) % 2 == 1) ? 1 : -1;
        }

        long low = 1;
        long minCoin = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minCoin = Math.min(minCoin, coins[i]);
        }
        long high = minCoin * k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = 0;

            for (int mask = 1; mask < numSubsets; mask++) {
                if (lcms[mask] != -1 && lcms[mask] <= mid) {
                    count += signs[mask] * (mid / lcms[mask]);
                }
            }

            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}