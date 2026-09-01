class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int maxMatch = 0;
        int[] prefixCount = count.clone();
        while (maxMatch < n) {
            int c = target.charAt(maxMatch) - 'a';
            if (prefixCount[c] > 0) {
                prefixCount[c]--;
                maxMatch++;
            } else {
                break;
            }
        }

        for (int i = Math.min(n - 1, maxMatch); i >= 0; i--) {
            int[] currentCount = count.clone();
            for (int j = 0; j < i; j++) {
                currentCount[target.charAt(j) - 'a']--;
            }

            int targetChar = target.charAt(i) - 'a';
            int nextChar = -1;
            for (int c = targetChar + 1; c < 26; c++) {
                if (currentCount[c] > 0) {
                    nextChar = c;
                    break;
                }
            }

            if (nextChar != -1) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    sb.append(target.charAt(j));
                }
                sb.append((char) ('a' + nextChar));
                currentCount[nextChar]--;

                for (int c = 0; c < 26; c++) {
                    while (currentCount[c] > 0) {
                        sb.append((char) ('a' + c));
                        currentCount[c]--;
                    }
                }
                return sb.toString();
            }
        }

        return "";
    }
}