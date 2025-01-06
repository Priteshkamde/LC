class Solution {

    class Pair {
        String first;
        int second;
        Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<String>(wordList);
        // is this assumed?
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;

            q.remove();
            if(word.equals(endWord)) 
                return steps;

            // extract every word from Q
            // swap one letter with all letters in alphabets
            // check if present in SET
            for(int i = 0 ; i < word.length() ; i++){
                for(char ch = 'a'; ch <= 'z' ; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }

        }
       return 0;
    }
}