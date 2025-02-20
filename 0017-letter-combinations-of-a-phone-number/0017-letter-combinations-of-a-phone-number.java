class Solution {
    List<String> result = null;
    String[] mapping = new String[]{"", "", "abc", "def", 
        "ghi", "jkl", "mno", 
        "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        result = new ArrayList();
        if(digits.length() == 0) 
            return result;
        backtrack(0, digits, new StringBuilder());
        
        return result;    
    }

    private void backtrack(int len, String digits, StringBuilder temp){
        if(len == digits.length()){
            result.add(temp.toString());
            return;
        }

        char ch = digits.charAt(len); 
        String str = mapping[ch-'0'];
        for(char c : str.toCharArray()) {
            temp.append(c);
            backtrack(len+1, digits, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}