class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    public void backtrack(List<String> res, String current_string, int open, int close, int max) {
        if(current_string.length() == max * 2) {
            res.add(current_string);
            return;
        }
        
        if(open < max) backtrack(res, current_string + "(", open+1, close, max);
        if(close < open) backtrack(res, current_string + ")", open, close+1, max);
    }
    
}