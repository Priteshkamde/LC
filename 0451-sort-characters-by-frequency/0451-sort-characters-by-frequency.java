class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] list = new List[s.length() + 1];

        for(char c : map.keySet()) {
            int index = map.get(c);
            if(list[index] == null) {
                list[index] = new ArrayList();
            }
            list[index].add(c);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = list.length -1 ; i >= 0 ; i-- ) {
            if(list[i] != null){
                for(char c : list[i]) {
                    sb.append(String.valueOf(c).repeat(i));
                }
            }
        }

        return sb.toString();
           
    }
}