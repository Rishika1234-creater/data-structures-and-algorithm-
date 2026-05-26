class Solution {
    public int maxProduct(int[] nums) {

        int currMax = nums[0];
        int currMin = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int temp = currMax;

            currMax = Math.max(num,
                    Math.max(num * currMax,
                             num * currMin));

            currMin = Math.min(num,
                    Math.min(num * temp,
                             num * currMin));

            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}