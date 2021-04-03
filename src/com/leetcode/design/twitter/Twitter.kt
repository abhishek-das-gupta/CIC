package com.leetcode.design.twitter

import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Twitter {

    /** Initialize your data structure here. */
    private val userToNewsFeed = HashMap<Int, LinkedList<TweetTime>>()
    private val userToFollowers = HashMap<Int, HashSet<Int>>()
    private val time = AtomicInteger(0)

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        if (!userToNewsFeed.containsKey(userId)) {
            userToNewsFeed[userId] = LinkedList()
        }
        userToNewsFeed[userId]!!.addFirst(TweetTime(tweetId, time.incrementAndGet()))
        if (userToNewsFeed[userId]?.size!! > 10) userToNewsFeed[userId]!!.removeLast()
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     *  Each item in the news feed must be posted by users who the user
     *  followed or by the user herself.
     *  Tweets must be ordered from most recent to least recent.
     *  */
    fun getNewsFeed(userId: Int): List<Int> {
        val allFeed = mutableListOf<TweetTime>()
        if (userToFollowers.containsKey(userId)) {
            allFeed.addAll(userToFollowers[userId]!!.flatMap {
                if (userToNewsFeed.containsKey(it)) userToNewsFeed[it]!! else listOf<TweetTime>()
            })
        }
        if (userToNewsFeed.containsKey(userId)) {
            allFeed.addAll(userToNewsFeed[userId]!!)
        }
        return allFeed.sortedByDescending { it.time }.map { it.tweetId }.take(10)
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        if (!userToFollowers.containsKey(followerId)) {
            userToFollowers[followerId] = HashSet()
        }
        userToFollowers[followerId]!!.add(followeeId)
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        userToFollowers[followerId]?.remove(followeeId)
    }

    class TweetTime(val tweetId: Int, val time: Int)
}



fun main() {
    val twitter = Twitter()
    twitter.postTweet(1, 5) // User 1 posts a new tweet (id = 5).

    twitter.getNewsFeed(1) // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]

    twitter.follow(1, 2) // User 1 follows user 2.

    twitter.postTweet(2, 6) // User 2 posts a new tweet (id = 6).

    twitter.getNewsFeed(1) // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.

    twitter.unfollow(1, 2) // User 1 unfollows user 2.

    twitter.getNewsFeed(1) // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */