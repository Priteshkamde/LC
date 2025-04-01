class Solution {
    public boolean checkValidString(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        return check(s, 0, 0, memo);
    }

// TLE if all the string content is *
    public boolean check(String s, int index, int count, Map<String, Boolean> memo) {
        if (count < 0)
            return false;

        if (index == s.length())
            return count==0;

        String key = index+","+count;
        if(memo.containsKey(key))
            return memo.get(key);
        
        boolean result;
        if(s.charAt(index) == '(')
            result = check(s, index+1, count+1, memo);

        else if(s.charAt(index) == ')')
            result = check(s, index+1, count-1, memo);

        // if(s.charAt(index) == '*')
        else {
            result = check(s, index+1, count+1, memo) || 
            check(s, index+1, count-1, memo) ||
            check(s, index+1, count, memo);
        }
        
        memo.put(key, result);
        return result;
    }
}