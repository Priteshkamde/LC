class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> resultList = new ArrayList<>();
        String temp = "";
        
        for(String word : words) {
            
            char[] c  = word.toCharArray();       
            Arrays.sort(c);
            
            String current = new String(c);
            
            if(!current.equals(temp)) { 
                resultList.add(word); 
            }
            
            temp = current;
            
        }
        
        return resultList;
    
    }
}



// return a list of strings 

// iterate thru words array
// go adjacency // increament index till it stays same

// incretment start index onlywhen anagrams donot match
// 