class Solution {
    public boolean isPalindrome(String s) {

        s = s.trim().toLowerCase();

        if (s.length() == 1)
            return true;
        int left = 0;
        int right = s.length() - 1;


        while (left <= right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;

            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            else {
                left++;
                right--;
            }
        }

        return true;
    }
}