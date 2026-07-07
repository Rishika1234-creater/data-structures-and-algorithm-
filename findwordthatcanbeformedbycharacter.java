class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;
        for (String word : words) {
            HashMap<Character, Integer> wordMap = new HashMap<>();
            for (char ch : word.toCharArray()) {
                wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
            }

            boolean canForm = true;
            for (char ch : wordMap.keySet()) {
                if (wordMap.get(ch) > charMap.getOrDefault(ch, 0)) {
                    canForm = false;
                    break;
                }
            }
            if (canForm) {
                ans += word.length();
            }
        }
        return ans;
    }
}