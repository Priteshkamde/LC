class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < features.length; i++)
            indexMap.put(features[i], i);

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> {
                    int eq = map.getOrDefault(b, 0) - map.getOrDefault(a, 0);

                    if (eq == 0) {
                        return indexMap.get(a) - indexMap.get(b);
                    }
                    return eq;
                });

        for (String response : responses) {
            Set<String> wordsInResponse = new HashSet<>();
            String[] words = response.split(" ");
            for (String word : words) {
                wordsInResponse.add(word.toLowerCase());
            }

            for (String feature : features) {
                if (wordsInResponse.contains(feature.toLowerCase())) {
                    map.put(feature, map.getOrDefault(feature, 0) + 1);
                }
            }
        }

        for (String f : features) {
            pq.add(f);
        }

        String[] result = new String[features.length];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }

        return result;
    }
}