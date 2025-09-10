class Solution {
    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String str : words) {
            sb.append(rev(str)).append(" ");
        }

        return sb.toString().trim();
    }

    public String rev(String x) {
        char[] s = x.toCharArray();
        int low = 0;
        int high = s.length-1;

        while(low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;

            low++;
            high--;
        }

        return new String(s);

    }
}