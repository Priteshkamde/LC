class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = s.length()-1 ; i >= 0; i--) {
            if(s.charAt(i) != '-'){
                if(count == k) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(Character.toUpperCase(s.charAt(i)));
                count+=1;
            }
            
        }

        return sb.reverse().toString();
    }
}