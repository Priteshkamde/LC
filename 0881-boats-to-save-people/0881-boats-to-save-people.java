class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boxes = 0;

        int low = 0;
        int high = people.length-1;
        
        while(low <= high) {
            if(people[low] + people[high] > limit) {
                boxes += 1;
                high -= 1;
            } else {
                boxes += 1;
                low += 1;
                high -= 1;
            }
        }

        return boxes;
    }
}