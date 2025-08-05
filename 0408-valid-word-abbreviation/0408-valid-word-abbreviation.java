class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int i = 0 ;
        int j = 0 ;
        // while loop
        // if we get a digit 
            // see if the next will also be a digits
            // extract all nums
            //  advance the pojnter i in word 
            // check if the i in word is same as j in abbr
        // else not a digit - then do side by side comparision

        // O (N + M)

        while(i < word.length() && j < abbr.length()) {
            if(Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') 
                    return false;

                int num = 0;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j)-'0');
                    j++;
                }
                i = i+num;
            } else {
                if(i >= word.length() || word.charAt(i) != abbr.charAt(j))
                    return false;
                i+=1;
                j+=1;
            }
        }


        if(i == word.length() && j == abbr.length())
            return true;

        return false;
        // end condition 
        // when both the corresponding pointers are at the end

    }
}