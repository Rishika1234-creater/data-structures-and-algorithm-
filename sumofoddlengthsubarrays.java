class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
       int n = arr.length;
       int total =0;
       for(int i=0;i<n;i++){
        int currentSum=0;
        for(int j=i;j<n;j++){
           currentSum+=arr[j]; 
           if((j - i + 1) % 2 != 0){
            total+=currentSum;
           } 
        }
       }
       return total;
    }
}
