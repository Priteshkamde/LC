class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] first = new int[26];
        int[] second = new int[26];

        for (char c : s1.toCharArray()) {
            first[c - 'a'] += 1;
        }

        for (int i = 0; i < s2.length(); i++) {
            second[s2.charAt(i) - 'a'] += 1;
            if (i >= s1.length())
                second[s2.charAt(i - s1.length()) - 'a'] -= 1;

            if (Arrays.equals(first, second)) {
                return true;

            }

        }
        return false;
    }
}