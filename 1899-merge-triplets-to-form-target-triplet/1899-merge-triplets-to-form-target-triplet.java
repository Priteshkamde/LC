class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            if (triplet[0] == target[0])
                found[0] = true;
            if (triplet[1] == target[1])
                found[1] = true;
            if (triplet[2] == target[2])
                found[2] = true;
        }

        return found[0] && found[1] && found[2];
    }
}