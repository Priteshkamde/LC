class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList();

        List<Integer> temp;

        
        result.add(new ArrayList(Arrays.asList(1)));
        if(rowIndex == 0) {
            return result.get(rowIndex);
        }
        
        result.add(new ArrayList(Arrays.asList(1,1)));
        if(rowIndex == 1) {
            return result.get(rowIndex);
        }

        for(int i = 2 ; i < rowIndex+1 ; i++) {
            temp = new ArrayList();
            temp.add(1);

            List<Integer> prev = result.get(i-1);
            for(int j = 1 ; j < prev.size(); j++) {
                temp.add(prev.get(j-1) + prev.get(j));
            }

            temp.add(1);

            result.add(temp);
        }

        return result.get(rowIndex);
    }
}