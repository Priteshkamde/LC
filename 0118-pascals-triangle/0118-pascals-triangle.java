class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList(Arrays.asList(1)));
        if(numRows == 1) return result;

        result.add(new ArrayList(Arrays.asList(1, 1)));
        if(numRows == 2) return result;

        List<Integer> temp;
        for(int i = 2 ; i < numRows ; i++) {
            temp = new ArrayList();
            temp.add(1);

            List<Integer> prevRow = result.get(i-1);
            for (int j = 1; j < prevRow.size(); j++) {
                temp.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            temp.add(1);
            result.add(temp);
        }

        return result;
        
    }
}