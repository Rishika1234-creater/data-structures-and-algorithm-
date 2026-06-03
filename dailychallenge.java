class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int minLandEnd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLandEnd = Math.min(minLandEnd, landStartTime[i] + landDuration[i]);
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int finish = Math.max(waterStartTime[j], minLandEnd) + waterDuration[j];
            ans = Math.min(ans, finish);
        }

        int minWaterEnd = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minWaterEnd = Math.min(minWaterEnd, waterStartTime[j] + waterDuration[j]);
        }
        for (int i = 0; i < n; i++) {
            int finish = Math.max(landStartTime[i], minWaterEnd) + landDuration[i];
            ans = Math.min(ans, finish);
        }

        return ans;
    }
}