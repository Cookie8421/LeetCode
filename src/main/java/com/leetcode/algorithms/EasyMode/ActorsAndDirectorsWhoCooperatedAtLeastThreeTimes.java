package com.leetcode.algorithms.EasyMode;

/**
 *
 * SQL Schema
 *
 * Create table If Not Exists ActorDirector (actor_id int, director_id int, timestamp int)
 * Truncate table ActorDirector
 * insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '1', '0')
 * insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '1', '1')
 * insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '1', '2')
 * insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '2', '3')
 * insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '2', '4')
 * insert into ActorDirector (actor_id, director_id, timestamp) values ('2', '1', '5')
 * insert into ActorDirector (actor_id, director_id, timestamp) values ('2', '1', '6')
 *
 * Table: ActorDirector
 *
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | actor_id    | int     |
 * | director_id | int     |
 * | timestamp   | int     |
 * +-------------+---------+
 * timestamp is the primary key column for this table.
 *
 *
 *
 * Write a SQL query for a report that provides the pairs (actor_id, director_id) where the actor has cooperated with the director at least three times.
 *
 * Return the result table in any order.
 *
 * The query result format is in the following example.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * ActorDirector table:
 * +-------------+-------------+-------------+
 * | actor_id    | director_id | timestamp   |
 * +-------------+-------------+-------------+
 * | 1           | 1           | 0           |
 * | 1           | 1           | 1           |
 * | 1           | 1           | 2           |
 * | 1           | 2           | 3           |
 * | 1           | 2           | 4           |
 * | 2           | 1           | 5           |
 * | 2           | 1           | 6           |
 * +-------------+-------------+-------------+
 * Output:
 * +-------------+-------------+
 * | actor_id    | director_id |
 * +-------------+-------------+
 * | 1           | 1           |
 * +-------------+-------------+
 * Explanation: The only pair is (1, 1) where they cooperated exactly 3 times.
 */
public class ActorsAndDirectorsWhoCooperatedAtLeastThreeTimes {

    //  Write your MySQL query statement below

    /**
     * Runtime: 621 ms, faster than 22.02% of MySQL online submissions for Actors and Directors Who Cooperated At Least Three Times.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Actors and Directors Who Cooperated At Least Three Times.
     */

    /*select a.actor_id, a.director_id from
    (select actor_id, director_id, count(*) as count from ActorDirector group by actor_id,director_id) a
    where a.count > 2*/
}
