class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer>ransomMap = new HashMap<>();
      for(char ch : ransomNote.toCharArray()){
            ransomMap.put(ch,ransomMap.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer>magazineMap = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            magazineMap.put(ch,magazineMap.getOrDefault(ch,0)+1);
        }
        for(char ch:ransomMap.keySet()){
            if(ransomMap.get(ch)>magazineMap.getOrDefault(ch,0)){
                return false;
            }
        }
        return true;
    }
}
