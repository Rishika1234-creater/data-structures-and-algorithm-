class Solution {
    public int maximumPopulation(int[][] logs) {
        int maximumPopulation = 0;
        int answerYear = 1950;
        for(int year = 1950;year<=2050;year++){
            int count = 0;
            for(int[]log:logs){
                if(log[0]<=year&&year<log[1]){
                    count++;
                }
                if(count>maximumPopulation){
                    maximumPopulation = count;
                    answerYear = year;
                }
            }
        }
        return answerYear;
    }
}
