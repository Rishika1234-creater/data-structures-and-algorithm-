class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Map.Entry<Character,Integer>>list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(a,b)->b.getValue()-a.getValue());
        StringBuilder ans = new StringBuilder();
        for(Map.Entry<Character,Integer>entry:list){
            char ch = entry.getKey();
            int freq = entry.getValue();
            while(freq>0){
                ans.append(ch);
                freq--;
            }
        }
        return ans.toString();
    }
}