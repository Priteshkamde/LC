class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<String>();
        
        for(String email : emails) {
            String email_split[] = email.split("@");
            String local_name = email_split[0].replace(".", "");
            String local_name_split[] = local_name.split("\\+");
            set.add(local_name_split[0]+"@"+email_split[1]);
        }
        System.out.println(set);
        return set.size();
    }
}