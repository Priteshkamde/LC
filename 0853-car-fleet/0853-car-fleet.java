class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int N = position.length;
        double[][] cars = new double[N][2];

        for(int i = 0 ; i < N ; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));

        int fleets = 0;
        double lastTime = 0;

        for(double[] car : cars) {
            double time = car[1];
            if(time > lastTime) {
                fleets += 1;
                lastTime = time;
            }
        }

        return fleets;

    }
}