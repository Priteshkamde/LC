class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sol = 0;
        int N = s.length() - 1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < N; i++) {

            if(romanMap.get(arr[i]) < romanMap.get(arr[i+1])) {
                sol = sol - romanMap.get(arr[i]);
            } else {
                sol = sol + romanMap.get(arr[i]);
            }
        }

        sol = sol + romanMap.get(arr[arr.length-1]); 
        return sol;
    }
}