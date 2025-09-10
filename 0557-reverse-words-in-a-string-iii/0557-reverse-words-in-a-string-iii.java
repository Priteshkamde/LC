class Solution {
    public String reverseWords(String s) {
        
        String result = "";
        
        for(String string : s.split(" ")) {
            
            char[] charArray = string.toCharArray();
            
            int low = 0;
            int high = charArray.length -1;
            
            while(low<high) {
                swap(charArray, low++, high--);
            }
            
            result= result+String.valueOf(charArray) +" ";
            
            
            
        }
        
        return result.substring(0, result.length() - 1);
        
    }
    
    public void swap(char[] c, int a, int b) {
        
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
        
    }  
}