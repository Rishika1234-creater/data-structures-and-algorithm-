class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        int maxFamilies = 2 * (n - map.size());

        for (int mask : map.values()) {
            boolean left = (mask & 0b0000111100) == 0;
            boolean right = (mask & 0b1111000000) == 0;
            boolean middle = (mask & 0b0011110000) == 0;

            if (left && right) {
                maxFamilies += 2;
            } else if (left || right || middle) {
                maxFamilies += 1;
            }
        }

        return maxFamilies;
    }
}