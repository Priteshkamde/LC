class Solution {
    List<String> result = null;
    String[] mapping = new String[] { "", "",
            "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        result = new ArrayList();
        if (digits.length() == 0)
            return result;
        backtrack(0, digits, new StringBuilder());

        return result;
    }

    // base case where we get a string char from initial stage and
    // append it with next letters in next number
    private void backtrack(int len, String digits, StringBuilder temp) {
        if (len == digits.length()) {
            result.add(temp.toString());
            return;
        }

        char ch = digits.charAt(len);
        // ch - '0' converts a character digit (e.g., '2') into an integer (2)
        String str = mapping[ch - '0'];
        // "abc"
        for (char c : str.toCharArray()) {
            // iterate using "a" from "abc"
            temp.append(c);
            // increment length
            // to move to next number in digits
            // extract "def"
            // call backtrack with "a" +
            backtrack(len + 1, digits, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}