class Solution {
    List<String> result = new ArrayList<>();
    String map[] = new String[]{
            "",
            "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
    public List<String> letterCombinations(String digits) {
        
        if(digits == null)
            return result;

        if(digits.length() == 0)
            return result;
        
        // (len, digits, String)
        StringBuilder sb = new StringBuilder(digits);
        backtrack(0, digits, new StringBuilder());

        return result;
    }

    private void backtrack(int currLen, String digits, StringBuilder temp){
        if(currLen == digits.length()) {
            result.add(temp.toString());
            return;
        }
 
        char ch = digits.charAt(currLen);
        String str = map[ch-'0'];
        for(char c : str.toCharArray()) {
            temp.append(c);
            backtrack(currLen+1, digits, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}