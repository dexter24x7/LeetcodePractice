package Hashing;
//355. Design Twitter

import java.util.*;

/**
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.
Implement the Twitter class:
Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 */
public class DesignTwitter {
    static class Tweet{
        int tweetId;
        int time;
        Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    Map<Integer, HashSet<Integer>> followMap;
    Map<Integer, ArrayList<Tweet>> tweetMap;
    int systemTime;

    public DesignTwitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        systemTime = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, systemTime++);
        ArrayList<Tweet> userTweets = tweetMap.getOrDefault(userId,new ArrayList<>());
        userTweets.add(tweet);
        tweetMap.put(userId,userTweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> latestTweets = new PriorityQueue<>((x,y) -> (y.time - x.time));
        HashSet<Integer> followees = followMap.getOrDefault(userId,new HashSet<>());
        ArrayList<Tweet> ownTweets = tweetMap.getOrDefault(userId,new ArrayList<>());
        latestTweets.addAll(ownTweets);
        if(followees!=null){
            for(int followee : followees){
                ArrayList<Tweet> userTweets = tweetMap.getOrDefault(followee,new ArrayList<>());
                latestTweets.addAll(userTweets);
            }
        }
        ArrayList<Integer> tweetIds = new ArrayList<>();
        for(int i=0; i<10&&!latestTweets.isEmpty(); i++){
            Tweet  tweet = latestTweets.poll();
            tweetIds.add(tweet.tweetId);
        }
        return tweetIds;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followees = followMap.get(followerId);
        if(followees == null) followees = new HashSet<>();
        followees.add(followeeId);
        followMap.put(followerId,followees);
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followees = followMap.get(followerId);
        if(followees!=null) followees.remove(followeeId);
        followMap.put(followerId,followees);
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1,5);
        System.out.println(twitter.getNewsFeed(1).toString());
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        twitter.unfollow(1,2);
        System.out.println(twitter.getNewsFeed(5).toString());
    }
}
