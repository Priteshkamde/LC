class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for(int j = i; j > 0 ; j--) {
                arr[j] = arr[j-1] + arr[j];
            }
        }

        return Arrays.asList(arr);
    }
}