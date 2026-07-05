class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[]diff=new int[n+1];
        for(int[]query:queries){
            int l = query[0];
            int r = query[1];
            diff[l]++;
            if(r+1<n)
            diff[r+1]--;
        }
        int coverage = 0;
        for(int i = 0;i<n;i++){
            coverage+=diff[i];
            if(coverage<nums[i])
            return false;
        }
        return true;
    }
}