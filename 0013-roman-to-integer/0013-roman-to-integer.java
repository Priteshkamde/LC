class Solution {
    public int romanToInt(String s) {
        int sum  = 0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        hm.put('I', 1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        
        // IV
// 1 + 5 - 2 
        
        for(int i = 0; i< s.length() ; i++) {
            if(s.charAt(i)=='V'||s.charAt(i)=='X'){
                if(i>0&&s.charAt(i-1)=='I'){
                    sum = sum - 2;
                }
            }
            
            if(s.charAt(i)=='L'||s.charAt(i)=='C'){
                if(i>0&&s.charAt(i-1)=='X'){
                    sum = sum - 20;
                }
            }
            
            if(s.charAt(i)=='D'||s.charAt(i)=='M'){
                if(i>0&&s.charAt(i-1)=='C'){
                    sum = sum - 200;
                }
            }
            sum += hm.get(s.charAt(i));
        }

        return sum;
    }
}