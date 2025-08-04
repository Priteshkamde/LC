class Solution {
    public int fib(int n) {
        Map<Integer, Integer> map = new HashMap<>(); 
        return calculateFib(n, map);
    }

    private int calculateFib(int n, Map<Integer, Integer> map) {

        if(map.containsKey(n))
            return map.get(n);

        if(n <= 1) {
            map.put(n, n);
            return n;
        }

        int sum = calculateFib(n-1, map) + calculateFib(n-2, map);
        map.put(n, sum);

        return map.get(n); 
    }

}