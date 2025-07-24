class Solution {
    public boolean isPalindrome(int x) {
        

        if (x < 0) return false;
        int og = x;

        int rev = 0;
        while(x > 0) {
            int lastDigit = x%10;
            rev = rev * 10 + lastDigit;
            x = x/10;
        }

        return og == rev;
    }
}