class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int N = s.length()-1;
        int sum = 0;

        for(int i = 0; i < N ; i++) {
            if(hm.get(s.charAt(i)) < hm.get(s.charAt(i+1))) {
                sum = sum - hm.get(s.charAt(i));
            }
            else {
                sum = sum + hm.get(s.charAt(i));
            }
        }
        
        sum = sum + hm.get(s.charAt(s.length()-1));
        return sum;
    }
}