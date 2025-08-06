class Solution {
    public boolean judgeCircle(String moves) {
        int countV = 0;
        int countH = 0;

        for(char c : moves.toCharArray()) {
            if(c == 'U') {
                countV++;
            } else if(c == 'D') {
                countV--;
            } else if(c == 'R') {
                countH++;
            } else {
                countH--;
            }
        }

        return countV == 0 && countH == 0;
    }
}