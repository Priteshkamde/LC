class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) 
            return true;

        String tempString = s.toLowerCase();
        tempString = tempString.replaceAll("[^a-z0-9]", "");
        System.out.println(tempString);

        int low = 0;
        int high = tempString.length()-1;
        while(low < high){
            if(tempString.charAt(low) != tempString.charAt(high)){
                return false;
            }
            else{
                low++;
                high--;
            }
        }

        return true;
    }
}