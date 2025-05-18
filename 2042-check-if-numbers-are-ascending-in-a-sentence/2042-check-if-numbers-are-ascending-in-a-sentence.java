class Solution {
    public boolean areNumbersAscending(String s) {

        int prev = 0;

        String[] strings = s.split(" ");
        for(String word : strings) {
            if(Character.isDigit(word.charAt(0))) {
                int currNum = Integer.parseInt(word);
                if(currNum <= prev) {
                    return false;
                }

                prev = currNum;
            }
        }

        return true;
    }
}