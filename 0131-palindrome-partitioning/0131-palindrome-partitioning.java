class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        backtrack(0, s, new ArrayList(), result);
        return result;
    }

    private void backtrack(int index, String s, List<String> temp, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList(temp));
            return;    
        }

        for(int i = index ; i < s.length() ; i++) {
            if(check(s, index, i)){
                temp.add(s.substring(index, i+1));
                backtrack(i+1, s, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean check(String s, int start, int end) {
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}