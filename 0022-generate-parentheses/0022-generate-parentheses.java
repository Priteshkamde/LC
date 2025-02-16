class Solution {
    public List<String> generateParenthesis(int n) {
        // use backtrack // recur
        // base case is to stop when output string length == n*2
        // until that keep appending brackets
        // helper(String output, String cur, openCount, closeCount, max)
        List<String> output = new ArrayList<String>();
        backtrack(output, "", 0, 0, n);
        return output;
    }

    public void
        backtrack(List<String> output, String currString, 
            int open, int close, int max) {

            // base case and 
            // add something to the list 
            if(currString.length() == max*2) {
                output.add(currString);
                return;
            } 

            // other cases will involve decision making
                
            if(open<max){
                backtrack(output, currString+"(", open+1, close, max);
            }
            if(close<open){
                backtrack(output, currString+")", open, close+1, max);
            }
         
    }
}