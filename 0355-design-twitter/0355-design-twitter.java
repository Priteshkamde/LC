import java.util.*;

class Tweet implements Comparable<Tweet>{
    int time;
    int tweetId;
    Tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }

    @Override
    public int compareTo(Tweet that) {
        return that.time - this.time;
    }
}

class User {
    int userId;
    HashSet<Integer> followers;
    List<Tweet> listOfTweets;

    public User(int userId) {
        this.userId = userId;
        followers = new HashSet<>();
        listOfTweets = new LinkedList<>();
    }
    public void addTweet(Tweet t){
        listOfTweets.addFirst(t);
    }

    public void addFollowers(int followeeId) {
        followers.add(followeeId);
    }

    public void removeFollowers(int followeeId) {
        followers.remove(followeeId);
    }
}

class Twitter {

    int timeCounter;
    HashMap<Integer, User> userMap;
    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter+=1;
        if(!userMap.containsKey(userId))
            userMap.put(userId, new User(userId));

        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId))
            return new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);
        for (int followerId : user.followers) {
            int count = 0;
            for(Tweet tweet : userMap.get(followerId).listOfTweets){
                pq.offer(tweet);
                count ++;
                if (count > 10) break;
            }
        }

        // self tweets
        int count = 0;
        for(Tweet tweet : user.listOfTweets){
            pq.offer(tweet);
            count ++;
            if (count > 10) break;
        }

        List<Integer> result = new ArrayList<>();
    
        while(!pq.isEmpty() && result.size()<10) {
            result.add(pq.poll().tweetId);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId))
            userMap.put(followerId, new User(followerId));
        if(!userMap.containsKey(followeeId))
            userMap.put(followeeId, new User(followeeId));

        User user = userMap.get(followerId);
        user.addFollowers(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId))
            return;

        User user = userMap.get(followerId);
        user.removeFollowers(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */