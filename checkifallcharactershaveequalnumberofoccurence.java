class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int expectedValue = -1;
        for(int value:map.values())
           if(expectedValue==-1){
              expectedValue = value;
           }else if(value!=expectedValue){
            return false;
           }
           return true;
    }
}