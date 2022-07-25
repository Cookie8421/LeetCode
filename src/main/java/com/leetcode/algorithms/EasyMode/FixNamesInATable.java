package com.leetcode.algorithms.EasyMode;

/**
 * SQL Schema
 *
 * Create table If Not Exists Users (user_id int, name varchar(40))
 * Truncate table Users
 * insert into Users (user_id, name) values ('1', 'aLice')
 * insert into Users (user_id, name) values ('2', 'bOB')
 *
 * Table: Users
 *
 * +----------------+---------+
 * | Column Name    | Type    |
 * +----------------+---------+
 * | user_id        | int     |
 * | name           | varchar |
 * +----------------+---------+
 * user_id is the primary key for this table.
 * This table contains the ID and the name of the user. The name consists of only lowercase and uppercase characters.
 *
 *
 *
 * Write an SQL query to fix the names so that only the first character is uppercase and the rest are lowercase.
 *
 * Return the result table ordered by user_id.
 *
 * The query result format is in the following example.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * Users table:
 * +---------+-------+
 * | user_id | name  |
 * +---------+-------+
 * | 1       | aLice |
 * | 2       | bOB   |
 * +---------+-------+
 * Output:
 * +---------+-------+
 * | user_id | name  |
 * +---------+-------+
 * | 1       | Alice |
 * | 2       | Bob   |
 * +---------+-------+
 */
public class FixNamesInATable {

    /**
     * Runtime: 743 ms, faster than 44.47% of MySQL online submissions for Fix Names in a Table.
     * Memory Usage: 0B, less than 100.00% of MySQL online submissions for Fix Names in a Table.
     */

    /*
    select user_id, concat(ucase(left(name, 1)), lcase(mid(name, 2, char_length(name)-1))) as name from Users order by user_id
     */
}
